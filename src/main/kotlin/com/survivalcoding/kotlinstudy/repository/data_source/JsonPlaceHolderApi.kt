package com.survivalcoding.kotlinstudy.repository.data_source

import com.survivalcoding.kotlinstudy.core.Response

interface JsonPlaceHolderApi {
    suspend fun getData(): Response<String>
}
