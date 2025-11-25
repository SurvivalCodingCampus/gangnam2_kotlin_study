package com.neouul.sesac.`15-dto-mapper`.dto

import kotlinx.serialization.Serializable

@Serializable
data class StoreDTO(
    val addr: String? = null,
    val code: String? = null,
    val created_at: String? = null,
    val lat: Double? = null,
    val lng: Double? = null,
    val name: String? = null,
    val remain_stat: String? = null,
    val stock_at: String? = null,
    val type: String? = null,
)