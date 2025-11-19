package com.survival.kotlinstudy.datasource

import kotlinx.coroutines.runBlocking
import java.io.File

class StockDataSourceImpl : StockDataSource {
    override suspend fun getStockListings(): List<StockListing> {
        val file = File("listing_status.csv")
        val data = file.readLines().toMutableList()
        data.removeAt(0)
        val listStockListing = mutableListOf<StockListing>()

        data.forEach {
            val list = it.split(",")
            val stockListing = StockListing(
                symbol = list[0],
                name = list[1],
                exchange = list[2],
                assetType = list[3],
                ipoDate = list[4],
                delistingDate = list[5],
                status = list[6]
            )
            listStockListing.add(stockListing)
        }
        return listStockListing
    }
}

fun main(): Unit = runBlocking {
    val stock = StockDataSourceImpl()

    println(stock.getStockListings().joinToString("\n"))
}