package com.survivalcoding.kotlinstudy.`14_data_source`.data_source

import com.survivalcoding.kotlinstudy.`14_data_source`.model.StockListing
import java.io.File
import java.time.LocalDate

class StockDataSourceImpl : StockDataSource {
    override suspend fun getStockListings(): List<StockListing> {
        val csv = File("src/main/resources/14_data_source/listing_status.csv").readLines()

        // 헤더 제거
        val rawData = csv.drop(1)


        // 한 줄씩 읽으면서 mapping
        return rawData
            .map { it.split(",") }
            .filter { stocks -> stocks[1].isNotBlank() }
            .map { stocks ->
                val symbol = stocks[0]
                val name = stocks[1]
                val exchange = stocks[2]
                val assetType = stocks[3]

                val ipoDate = LocalDate.parse(stocks[4])

                val delistingDate =
                    if (stocks[5] == "null") {
                        null
                    } else {
                        LocalDate.parse(stocks[5])
                    }

                val status = stocks[6]

                StockListing(
                    symbol = symbol,
                    name = name,
                    exchange = exchange,
                    assetType = assetType,
                    ipoDate = ipoDate,
                    delistingDate = delistingDate,
                    status = status
                )
            }
    }
}
