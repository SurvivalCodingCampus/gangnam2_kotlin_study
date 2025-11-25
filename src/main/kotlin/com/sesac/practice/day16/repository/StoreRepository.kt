package com.sesac.practice.day16.repository

import com.sesac.practice.day16.model.Store

interface StoreRepository {
    suspend fun getStores(): List<Store>
}
