package com.luca.kotlinstudy._17_dto.repository

import com.luca.kotlinstudy._17_dto.model.Store

interface StoreRepository {
    suspend fun getStores(): List<Store>
}