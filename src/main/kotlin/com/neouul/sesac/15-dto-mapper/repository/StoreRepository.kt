package com.neouul.sesac.`15-dto-mapper`.repository

import com.neouul.sesac.`15-dto-mapper`.model.Store

interface StoreRepository {
    suspend fun getStores(): List<Store>
}