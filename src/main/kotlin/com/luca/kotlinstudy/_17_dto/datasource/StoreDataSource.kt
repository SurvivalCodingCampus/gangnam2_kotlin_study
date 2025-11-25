package com.luca.kotlinstudy._17_dto.datasource

import com.luca.kotlinstudy._17_dto.dto.StoreDTO
import com.luca.kotlinstudy.core.Response

interface StoreDataSource {
    suspend fun getStores(): Response<List<StoreDTO>>
}