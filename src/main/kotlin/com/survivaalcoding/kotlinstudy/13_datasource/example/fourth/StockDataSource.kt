package com.survivaalcoding.kotlinstudy.`13_datasource`.example.fourth

import com.survivaalcoding.kotlinstudy.`13_datasource`.example.fourth.StockListing

interface StockDataSource {
    suspend fun getStockListings(): List<StockListing>
}