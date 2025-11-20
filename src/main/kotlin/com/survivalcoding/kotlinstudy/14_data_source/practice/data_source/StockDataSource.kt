package com.survivalcoding.kotlinstudy.`14_data_source`.practice.data_source

import com.survivalcoding.kotlinstudy.`14_data_source`.practice.model.StockListing

interface StockDataSource {
    suspend fun getStockListings(): List<StockListing>
}