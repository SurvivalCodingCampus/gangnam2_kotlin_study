package com.survivaalcoding.kotlinstudy.`11_debug_lambda`.example

import kotlinx.serialization.Serializable

@Serializable
data class CollectionChartDataList(val collectionName: String, val collectionSalePrice: List<CollectionSalePrice>? = null)