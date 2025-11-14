package com.survivaalcoding.kotlinstudy.`11_debug_lambda`.example

import kotlinx.serialization.Serializable

@Serializable
data class CollectionChartData(val collectionChartDataList: List<CollectionChartDataList>)