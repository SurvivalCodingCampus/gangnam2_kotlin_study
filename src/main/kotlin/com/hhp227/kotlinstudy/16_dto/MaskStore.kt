package com.hhp227.kotlinstudy.`16_dto`

import kotlinx.serialization.Serializable

@Serializable
data class MaskStore(val count: Int, val stores: List<StoreDto>)