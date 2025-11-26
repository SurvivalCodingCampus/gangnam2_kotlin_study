package com.ezlevup.my.day251125.exercise.data_source

import com.ezlevup.my.core.HttpClientProvider
import com.ezlevup.my.core.Response
import com.ezlevup.my.core.toResponse
import com.ezlevup.my.day251125.exercise.dto.PhotoDto
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PhotoDataSourceImpl(
    private val client: HttpClient = HttpClientProvider.client,
) : PhotoDataSource {
    override suspend fun getPhotos(): Response<List<PhotoDto>> = withContext(Dispatchers.IO) {
        val httpResponse = client.get("https://")
        httpResponse.toResponse<List<PhotoDto>>()
    }
}
