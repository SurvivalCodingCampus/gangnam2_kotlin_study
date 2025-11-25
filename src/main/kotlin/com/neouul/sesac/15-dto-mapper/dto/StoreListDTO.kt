package com.neouul.sesac.`15-dto-mapper`.dto

import kotlinx.serialization.Serializable

@Serializable
data class StoreListDTO(
    val count: Int? = null,
    val stores: List<StoreDTO?>? = null,
)