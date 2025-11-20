package com.survivalcoding.kotlinstudy.`14_data_source`.practice.data_source

import com.survivalcoding.kotlinstudy.`14_data_source`.practice.model.StockListing
import kotlinx.coroutines.runBlocking
import java.io.File

class StockDataSourceImpl(
    val file: File
) : StockDataSource {
    override suspend fun getStockListings(): List<StockListing> {
        val csvList = file.readLines().map {
            it.split(',')
        }
        val listings = mutableListOf<StockListing>()

        for (i in 1..<csvList.size) {
            val row = csvList[i]
            if (row[1] == "") continue

            val listing = StockListing(
                row[0],
                row[1],
                row[2],
                row[3],
                row[4],
                row[5],
                row[6]
            )
            listings.add(listing)
        }
        return listings
    }
}

fun main(): Unit = runBlocking {
    val file = File("listing_status.csv")
    val csvData = StockDataSourceImpl(file).getStockListings()

    println(csvData)
}