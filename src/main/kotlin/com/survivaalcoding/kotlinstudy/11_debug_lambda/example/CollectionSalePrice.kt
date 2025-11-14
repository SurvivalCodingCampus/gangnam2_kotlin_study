package com.survivaalcoding.kotlinstudy.`11_debug_lambda`.example

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class CollectionSalePrice(val price: Double, val cvtDatetime: LocalDateTime)