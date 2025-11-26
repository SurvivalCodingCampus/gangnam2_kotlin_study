package com.ezlevup.my.day251125.exercise.data_source


import com.ezlevup.my.core.Response
import com.ezlevup.my.day251125.exercise.dto.MaskStoreDto

interface StoreDataSource {
    suspend fun getStores(): Response<MaskStoreDto>
}


