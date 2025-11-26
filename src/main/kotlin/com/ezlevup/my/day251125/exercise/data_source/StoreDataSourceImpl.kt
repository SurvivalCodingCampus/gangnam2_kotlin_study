package com.ezlevup.my.day251125.exercise.data_source

import com.ezlevup.my.core.HttpClientProvider
import com.ezlevup.my.core.Response
import com.ezlevup.my.core.toResponse
import com.ezlevup.my.day251125.exercise.dto.MaskStoreDto
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StoreDataSourceImpl(
    private val client: HttpClient = HttpClientProvider.client,
) : StoreDataSource {
    override suspend fun getStores(): Response<MaskStoreDto> = withContext(Dispatchers.IO) {
        val httpResponse =
            client.get("https://gist.githubusercontent.com/junsuk5/2b34223fb2368d2bf44c85082745649a/raw/00cb276cb4f4f9573d868e88382f6f7f6759df31/mask_store.json")
        httpResponse.toResponse<MaskStoreDto>()
    }
}
