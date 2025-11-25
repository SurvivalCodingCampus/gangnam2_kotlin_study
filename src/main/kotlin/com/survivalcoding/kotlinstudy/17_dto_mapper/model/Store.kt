package com.survivalcoding.kotlinstudy.`17_dto_mapper`.model

import kotlinx.serialization.Serializable

@Serializable
data class Stores(
    val count: Int,
    val stores: List<Store>

)

@Serializable
data class Store(
    val address: String,
    val createdAt: String? = null,
    val name: String,
    val remainStat: String? = null,
    val stockAt: String? = null,
)

