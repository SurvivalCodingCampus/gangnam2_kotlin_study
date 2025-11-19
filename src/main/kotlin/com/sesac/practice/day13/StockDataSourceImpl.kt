package com.sesac.practice.day13

import java.io.File

class StockDataSourceImpl(
    val filename: String,
) : StockDataSource {
    override suspend fun getStockListings(): List<StockListing> {
        val file = File(filename)
        val readLines = file.readLines()

        return readLines.mapNotNull(::decodeFromString)
            .filterIndexed { index, _ -> isNotHeader(index) }
    }

    private fun decodeFromString(csv: String): StockListing? {
        val data = csv.split(CSV_SEPARATOR)

        if (data.size != CSV_DATA_SIZE) {
            return null
        }

        val symbol = data[0]
        val name = data[1]
        val exchange = data[2]
        val assetType = data[3]
        val ipoDate = data[4]
        val delistingDate = data[5].toNull()
        val status = data[6]

        if (name.isEmpty()) {
            return null
        }

        return StockListing(
            symbol,
            name,
            exchange,
            assetType,
            ipoDate,
            delistingDate,
            status,
        )
    }

    private fun String.toNull(): String? = if (this == NULL_STRING) null else this

    private fun isNotHeader(index: Int): Boolean = index != CSV_HEADER_INDEX

    companion object {
        const val CSV_SEPARATOR = ","
        const val CSV_DATA_SIZE = 7
        const val NULL_STRING = "null"
        const val CSV_HEADER_INDEX = 0
    }
}
