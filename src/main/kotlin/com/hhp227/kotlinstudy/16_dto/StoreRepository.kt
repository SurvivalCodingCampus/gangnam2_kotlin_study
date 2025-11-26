package com.hhp227.kotlinstudy.`16_dto`

interface StoreRepository {
    suspend fun getStores(): List<Store>
}