package com.ezlevup.my.day251119.exercise

import kotlinx.coroutines.runBlocking
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
    suspend fun getStockListings(): List<StockListing>
}

class StockDataSourceImpl : StockDataSource {

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

    override suspend fun getStockListings(): List<StockListing> {
        val file = File("listing_status.csv")
        val stocks = mutableListOf<StockListing>()

        file.forEachLine { line ->
            if (line.startsWith("symbol,name,exchange,assetType,ipoDate,delistingDate,status")) return@forEachLine
            stocks.add(parseStockListing(line))
        }

        return stocks
    }
}

fun main(): Unit = runBlocking {
    val stockDataSource = StockDataSourceImpl()
    val stockData = stockDataSource.getStockListings()
    stockData.take(5).forEach { println(it) }
    println(stockData.count())
}

