package com.neouul.sesac.`15-dto-mapper`.data_source

import com.neouul.sesac.`15-dto-mapper`.dto.StoreDTO
import com.neouul.sesac.`15-dto-mapper`.dto.StoreListDTO
import com.neouul.sesac.`15-dto-mapper`.repository.StoreRepository
import com.neouul.sesac.`15-dto-mapper`.repository.StoreRepositoryImpl
import com.neouul.sesac.core.Response
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.util.toMap
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

class StoreRemoteDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO),
) : RemoteDataSource {

    override suspend fun getStores(): Response<StoreListDTO?> {
        val response = client.get(BASE_URL)

        // 상태 코드 처리
        if (response.status != HttpStatusCode.OK) {
            return Response(
                response.status.value,
                response.headers.toMap(),
                null
            )
        }

        return Response(
            response.status.value,
            response.headers.toMap(),
            Json.decodeFromString<StoreListDTO>(response.bodyAsText())
        )
    }

    companion object {
        private const val BASE_URL =
            "https://gist.githubusercontent.com/junsuk5/2b34223fb2368d2bf44c85082745649a/raw/00cb276cb4f4f9573d868e88382f6f7f6759df31/mask_store.json"
    }
}

fun main(): Unit = runBlocking {
    val dataSource = StoreRemoteDataSourceImpl()
//    println(dataSource.getStores().body)

    val repository = StoreRepositoryImpl(dataSource)
//    println(repository.getStores())
    println(repository.getStores().size)    // 222 - 1(필드없음) - 5(null) = 216
}