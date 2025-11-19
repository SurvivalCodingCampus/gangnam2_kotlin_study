package com.survivalcoding.kotlinstudy.`14_data_source`.practice.model

import kotlinx.serialization.Serializable

@Serializable
data class StockListing(
    val symbol: String,
    val name: String,
    val exchange: String,
    val assetType: String,
    val ipoDate: String,
    val delistingDate: String,
    val status: String
)