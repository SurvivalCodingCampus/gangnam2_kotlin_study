package com.luca.kotlinstudy._14_dataSource

import com.luca.kotlinstudy._14_dataSource.StockDataSourceImpl.Companion.stockFilePath
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import java.io.File

@Serializable
data class StockListing(
    val symbol: String,
    val name: String,
    val exchange: String,
    val assetType: String,
    val ipoDate: String,
    val delistingDate: String,
    val status: String,
)

interface StockDataSource {
    suspend fun getStockListings(): List<StockListing>
}

class StockDataSourceImpl(
    private val filePath: String
) : StockDataSource {
    override suspend fun getStockListings(): List<StockListing> = withContext(Dispatchers.IO) {
        val lines = File(filePath).readLines()

        // CSV 헤더 읽기 (첫 줄)
        // val header = lines.first().split(",")

        lines
            .drop(1) // 헤더 첫줄 제거
            .map { it.split(",") }
            .filter { parts ->
                // 필드 개수가 충분하고 name이 비어있지 않은 항목만 유지
                parts.size >= 7 && parts[1].isNotBlank() // isNotBlank :name이 빈문자열, 공백이 아니여야 true, null은 스플릿해서 없음
            }
            .map { parts ->
                StockListing(
                    symbol = parts[0],
                    name = parts[1],
                    exchange = parts[2],
                    assetType = parts[3],
                    ipoDate = parts[4],
                    delistingDate = parts[5],
                    status = parts[6]
                )
            }
    }

    companion object {
        val stockFilePath = "src/main/kotlin/com/luca/kotlinstudy/_14_dataSource/listing_status.csv"
    }
}

fun main() = runBlocking {
    val dataSource: StockDataSource = StockDataSourceImpl(stockFilePath)
    val stockListing = dataSource.getStockListings()
    println(stockListing)
}