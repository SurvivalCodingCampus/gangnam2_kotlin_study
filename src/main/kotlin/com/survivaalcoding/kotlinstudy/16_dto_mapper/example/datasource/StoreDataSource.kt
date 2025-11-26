package com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.datasource

import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.core.Response
import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.dto.StoreResponse

interface StoreDataSource {
    suspend fun getStores(): Response<StoreResponse>
}