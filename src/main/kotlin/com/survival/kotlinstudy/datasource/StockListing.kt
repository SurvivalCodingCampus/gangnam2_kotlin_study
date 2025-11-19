package com.survival.kotlinstudy.datasource

data class StockListing(
    val symbol: String,
    val name: String,
    val exchange: String,
    val assetType: String,
    val ipoDate: String,
    val delistingDate: String? = null,
    val status: String,
)
