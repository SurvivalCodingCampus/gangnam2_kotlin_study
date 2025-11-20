package com.survival.kotlinstudy.datasource

interface StockDataSource {
    suspend fun getStockListings(): List<StockListing>
}