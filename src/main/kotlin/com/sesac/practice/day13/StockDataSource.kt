package com.sesac.practice.day13

interface StockDataSource {
    suspend fun getStockListings(): List<StockListing>
}
