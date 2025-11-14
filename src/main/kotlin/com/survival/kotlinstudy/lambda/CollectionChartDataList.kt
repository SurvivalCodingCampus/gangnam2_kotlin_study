package com.survival.kotlinstudy.lambda

import kotlinx.serialization.Serializable

@Serializable
data class CollectionChartDataList(
    val collectionName: String,
    val collectionSalePrice: List<CollectionSalePrice>? = null
)
