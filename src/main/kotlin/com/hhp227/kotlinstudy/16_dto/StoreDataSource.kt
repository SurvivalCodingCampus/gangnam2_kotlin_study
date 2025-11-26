package com.hhp227.kotlinstudy.`16_dto`

interface StoreDataSource {
    suspend fun fetchMaskStore(): MaskStore
}