package com.neouul.sesac.`10-debugging`

import kotlinx.serialization.Serializable

@Serializable
data class CollectionChartDataList(
    val collectionChartDataList: List<Collection>
)

@Serializable
data class Collection(
    val collectionName: String,
    val collectionSalePrice: List<ChartData>? = null,
)

@Serializable
data class ChartData(
    val price: Double,
    val cvtDatetime: String,
)