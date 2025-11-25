package com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.repository

import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.model.Store

interface StoreRepository {
    suspend fun getStores(): List<Store>
}