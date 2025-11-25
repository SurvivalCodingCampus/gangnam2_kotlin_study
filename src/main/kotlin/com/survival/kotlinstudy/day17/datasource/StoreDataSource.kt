package com.survival.kotlinstudy.day17.datasource

import com.survival.kotlinstudy.day17.dto.StoreListDto

interface StoreDataSource {
    suspend fun getStores(): StoreListDto
}