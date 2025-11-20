package com.survivalcoding.kotlinstudy.`14_data_source`.data_source

import com.survivalcoding.kotlinstudy.`14_data_source`.model.StockListing

interface StockDataSource {
    suspend fun getStockListings(): List<StockListing>
}