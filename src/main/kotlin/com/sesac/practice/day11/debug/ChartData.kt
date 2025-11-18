package com.sesac.practice.day11.debug

import kotlinx.serialization.Serializable

@Serializable
data class ChartData(
    val collectionChartDataList: List<CollectionChartData>? = null,
)

@Serializable
data class CollectionChartData(
    val collectionName: String? = null,
    val collectionSalePrice: List<SalePrice>? = null,
)

@Serializable
data class SalePrice(
    val price: Double? = null,
    val cvtDatetime: String? = null,
)
