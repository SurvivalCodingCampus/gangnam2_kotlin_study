package _251119_datasource.exercise4

import kotlinx.serialization.Serializable

@Serializable
data class StockListing(
    val symbol: String? = null,
    val name: String? = null,
    val exchange: String? = null,
    val assetType: String? = null,
    val ipoDate: String? = null,
    val delistingDate: String? = null,
    val status: String? = null
)