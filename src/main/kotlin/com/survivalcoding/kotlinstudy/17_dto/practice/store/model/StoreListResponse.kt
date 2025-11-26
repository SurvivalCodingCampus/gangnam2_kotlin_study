package com.survivalcoding.kotlinstudy.`17_dto`.practice.store.model

data class StoreListResponse(
    val count: Int,
    val stores: List<Store>
)