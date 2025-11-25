package com.neouul.sesac.`15-dto-mapper`.stores.repository

import com.neouul.sesac.`15-dto-mapper`.stores.model.Store

interface StoreRepository {
    suspend fun getStores(): List<Store>
}