package com.survivalcoding.kotlinstudy.`17_dto_mapper`.data_source

import com.survivalcoding.kotlinstudy.`17_dto_mapper`.dto.StoreDto

interface StoreDataSource {
    suspend fun getStores(): List<StoreDto>
}