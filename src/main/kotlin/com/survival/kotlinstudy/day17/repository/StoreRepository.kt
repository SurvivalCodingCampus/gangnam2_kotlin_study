package com.survival.kotlinstudy.day17.repository

import com.survival.kotlinstudy.day17.model.Store

interface StoreRepository {
    suspend fun getStores(): List<Store>
}