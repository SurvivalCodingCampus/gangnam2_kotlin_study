package com.survivalcoding.kotlinstudy.`17_dto_mapper`.repository

import com.survivalcoding.kotlinstudy.`17_dto_mapper`.model.Store

interface StoreRepository {
    suspend fun getStores(): List<Store>
}