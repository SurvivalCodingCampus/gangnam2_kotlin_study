package com.survivalcoding.kotlinstudy.`17_dto`.practice.store.data_source

import com.survivalcoding.kotlinstudy.`17_dto`.practice.store.dto.StoreDto

interface StoreDataSource {
    suspend fun getStores(): List<StoreDto>
    suspend fun getStore(code: Int): StoreDto
}