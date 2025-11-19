package com.survivaalcoding.kotlinstudy.`13_datasource`.example.fourth

import kotlinx.serialization.Serializable

@Serializable
data class StockListing(
    val symbol: String,
    val name: String? = null,
    val exchange: String,
    val assetType: String,
    val ipoDate: String,
    val delistingDate: String? = null,
    val status: String
)
