package com.ezlevup.my.day251119.exercise

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import java.io.File


@Serializable
data class StockListing(
    var symbol: String? = null,
    var name: String? = null,
    var exchange: String? = null,
    var assetType: String? = null,
    var ipoDate: String? = null,
    var delistingDate: String? = null,
    var status: String? = null,
)

interface StockDataSource {
    suspend fun getStockListings(forceReload: Boolean = false): List<StockListing>
}

class StockDataSourceImpl(
    private val file: File = File("listing_status.csv"),
) : StockDataSource {

    val stocks = mutableListOf<StockListing>()
    private var lastLoadedAt: Long = 0L // 마지막으로 파일 변경 시간

    fun parseStockListing(line: String): StockListing {
        val row = line.split(',')
        return StockListing(
            row[0],
            row[1],
            row[2],
            row[3],
            row[4],
            row[5],
            row[6]
        )
    }

    suspend fun loadFromFile(): Unit = withContext(Dispatchers.IO) {
        stocks.clear()
//        file.forEachLine { line ->
//            // 첫 줄 제외
//            if (line.startsWith("symbol,name,exchange,assetType,ipoDate,delistingDate,status")) {
//                return@forEachLine
//            }
//
//            stocks.add(parseStockListing(line))
//        }

        stocks.addAll(file.readLines().drop(1).map { parseStockListing(it) })
    }

    override suspend fun getStockListings(forceReload: Boolean): List<StockListing> {
        val lastModified: Long = file.lastModified() // 파일이 마지막으로 수정된 시간
        if (forceReload || stocks.isEmpty() || lastModified != lastLoadedAt) {
            loadFromFile()
            lastLoadedAt = lastModified
        }

        return stocks
    }
}

fun main(): Unit = runBlocking {
    val stockDataSource = StockDataSourceImpl()
    val stockData = stockDataSource.getStockListings()
    stockData.take(5).forEach { println(it) }
    println(stockData.count())

    // 불량 데이터 확인
    stockData.filter { it ->
        it.symbol.isNullOrEmpty()
                || it.name.isNullOrEmpty()
                || it.exchange.isNullOrEmpty()
                || it.assetType.isNullOrEmpty()
                || it.ipoDate == null
                // || it.delistingDate.isNullOrEmpty()
                || it.status.isNullOrEmpty()
    }.forEach { println(it) }
}

