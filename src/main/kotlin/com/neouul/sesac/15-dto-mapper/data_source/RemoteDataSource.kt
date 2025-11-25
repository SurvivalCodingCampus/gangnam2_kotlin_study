package com.neouul.sesac.`15-dto-mapper`.data_source

import com.neouul.sesac.`15-dto-mapper`.dto.StoreListDTO
import com.neouul.sesac.core.Response

interface RemoteDataSource {
    suspend fun getStores(): Response<StoreListDTO?>
}