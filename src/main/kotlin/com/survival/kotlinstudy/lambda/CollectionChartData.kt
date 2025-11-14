package com.survival.kotlinstudy.lambda

import kotlinx.serialization.Serializable

@Serializable
data class CollectionChartData(
    val collectionChartDataList: List<CollectionChartDataList>
)
