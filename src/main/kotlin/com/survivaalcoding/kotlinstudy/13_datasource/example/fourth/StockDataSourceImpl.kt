package com.survivaalcoding.kotlinstudy.`13_datasource`.example.fourth

import com.survivaalcoding.kotlinstudy.`13_datasource`.example.FileUtils
import com.survivaalcoding.kotlinstudy.`13_datasource`.example.SerializationUtils

class StockDataSourceImpl : StockDataSource {
    override suspend fun getStockListings(): List<StockListing> {
        val fileText = FileUtils.getFileText("$DIR_PATH$FILE_NAME")

        return SerializationUtils.deserialization(
            SerializationUtils.csvToJson(fileText)
        )
    }

    companion object {
        private const val DIR_PATH = "src/main/kotlin/com/survivaalcoding/kotlinstudy/13_datasource/example/fourth/"
        private const val FILE_NAME = "listing_status.csv"
    }
}
