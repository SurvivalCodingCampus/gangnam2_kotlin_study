package com.sesac.practice.day16.datasource

import com.sesac.practice.day16.core.Response
import com.sesac.practice.day16.dto.StoresDto

interface StoreDataSource {
    suspend fun getStores(): Response<StoresDto>
}
