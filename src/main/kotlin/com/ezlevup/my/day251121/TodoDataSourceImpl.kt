package com.ezlevup.my.day251121

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

class TodoDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO)
) : TodoDataSource {

    override suspend fun getTodos(): List<Todo> {
        val response = client.get("https://jsonplaceholder.typicode.com/todos")
        return Json.decodeFromString<List<Todo>>(response.bodyAsText())
    }

    override suspend fun getTodo(id: Int): Todo {
        val response = client.get("https://jsonplaceholder.typicode.com/todos/$id")
        return Todo.fromJson(response.bodyAsText())
    }

    override suspend fun postTodo(newTodo: Todo): Todo {
        val response = client.post("https://jsonplaceholder.typicode.com/todos") {
            // 서버에 전송할 콘텐츠 설정
            contentType(ContentType.Application.Json)
            // newTodo 객체를 JSON으로 직렬화하여 본문에 포함
            //setBody(newTodo)
            setBody(Json.encodeToString(newTodo))  // 수동 직렬화
        }

        // 서버가 응답한 새로 생성된 Todo 객체를 역직렬화하여 반환
        return Json.decodeFromString<Todo>(response.bodyAsText())
    }

}