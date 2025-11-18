package com.survival.kotlinstudy.lambda

import kotlinx.serialization.Serializable

@Serializable
data class CollectionSalePrice(
    val price: Double,
    val cvtDatetime: String
)
