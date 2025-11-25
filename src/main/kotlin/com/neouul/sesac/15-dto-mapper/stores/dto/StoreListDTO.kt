package com.neouul.sesac.`15-dto-mapper`.stores.dto

import kotlinx.serialization.Serializable

@Serializable
data class StoreListDTO(
    val count: Int? = null,
    val stores: List<StoreDTO?>? = null,
)