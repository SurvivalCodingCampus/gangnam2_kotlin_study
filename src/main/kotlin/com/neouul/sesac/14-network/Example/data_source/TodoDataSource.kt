package com.neouul.sesac.`14-network`.Example.data_source

import com.neouul.sesac.`14-network`.Example.model.Todo
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

interface TodoDataSource {
    suspend fun getTodos(): List<Todo>
    suspend fun getTodo(id: Int): Todo
}

class TodoDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO),
) : TodoDataSource {

    override suspend fun getTodos(): List<Todo> {
        val response = client.get(urlString = "https://jsonplaceholder.typicode.com/todos")
        return Json.decodeFromString(response.bodyAsText())
    }

    override suspend fun getTodo(id: Int): Todo {
        val response = client.get(urlString = "https://jsonplaceholder.typicode.com/todos/$id")
        return Json.decodeFromString(response.bodyAsText())
    }
}