package com.neouul.sesac.`12-datasource`

interface StockDataSource {
    suspend fun getStockListings(): List<StockListing>
}