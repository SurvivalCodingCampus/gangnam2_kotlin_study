package com.survivalcoding.kotlinstudy.`17_dto`.practice.store.repository

import com.survivalcoding.kotlinstudy.`17_dto`.practice.store.model.Store

interface StoreRepository {
    suspend fun getStores(): List<Store>
    suspend fun getStore(code: Int): Store
}