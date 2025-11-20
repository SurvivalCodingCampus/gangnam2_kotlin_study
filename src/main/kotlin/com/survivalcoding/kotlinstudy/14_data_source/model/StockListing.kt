package com.survivalcoding.kotlinstudy.`14_data_source`.model

import java.time.LocalDate

data class StockListing(
    val symbol: String,
    val name: String,
    val exchange: String,
    val assetType: String,
    val ipoDate: LocalDate,
    val delistingDate: LocalDate?,
    val status: String,
)
