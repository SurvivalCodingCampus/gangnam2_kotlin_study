package com.neouul.sesac.`15-dto-mapper`.stores.data_source

import com.neouul.sesac.`15-dto-mapper`.stores.dto.StoreListDTO
import com.neouul.sesac.core.Response

interface RemoteDataSource {
    suspend fun getStores(): Response<StoreListDTO?>
}