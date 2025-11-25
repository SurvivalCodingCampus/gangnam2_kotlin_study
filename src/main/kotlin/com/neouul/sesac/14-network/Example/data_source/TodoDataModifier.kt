package com.neouul.sesac.`14-network`.Example.data_source

import com.neouul.sesac.`14-network`.Example.model.Todo
import com.neouul.sesac.`14-network`.Example.model.TodoPatch
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.delete
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.json.Json

interface TodoDataModifier {
    suspend fun postTodo(newTodo: Todo): Todo   // 새로운 할일 추가
    suspend fun putTodo(id: Int, updateTodo: Todo): Todo    // 할일 전부 업데이트
    suspend fun patchTodoTitle(id: Int, newTitle: String): Todo // 할일 제목 업데이트
    suspend fun deleteTodo(id: Int)     // 할일 삭제
}

class TodoDataModifierImpl(
    private val client: HttpClient = HttpClient(CIO),
) : TodoDataModifier {

    override suspend fun postTodo(newTodo: Todo): Todo {
        val response = client.post("https://jsonplaceholder.typicode.com/posts"){
            contentType(ContentType.Application.Json)   // 서버에 전송할 콘텐츠 설정 (body의 타입?)
            setBody(newTodo)    // newTodo 객체를 JSON으로 직렬화하여 본문에 포함
        }

        // 서버한테 응답받은 새 할일 객체를 역직렬화하여 반환
        return Json.decodeFromString(response.bodyAsText())
    }

    override suspend fun putTodo(
        id: Int,
        updateTodo: Todo,
    ): Todo {
        val response = client.put("https://jsonplaceholder.typicode.com/posts/$id"){
            contentType(ContentType.Application.Json)   // 서버에 전송할 콘텐츠 설정
            setBody(updateTodo)    // 업데이트된 할일 객체를 JSON으로 직렬화하여 본문에 포함
        }

        // 서버한테 응답받은 새 할일 객체를 역직렬화하여 반환
        return Json.decodeFromString(response.bodyAsText())
    }

    override suspend fun patchTodoTitle(
        id: Int,
        newTitle: String,
    ): Todo {
        val patchBody = TodoPatch(title = newTitle)

        val response = client.patch("https://jsonplaceholder.typicode.com/posts/$id"){
            contentType(ContentType.Application.Json)   // 서버에 전송할 콘텐츠 설정
            setBody(patchBody)    // 부분 업데이트할 객체를 JSON으로 직렬화하여 본문에 포함
        }

        // 서버한테 응답받은 새 할일 객체를 역직렬화하여 반환
        return Json.decodeFromString(response.bodyAsText())
    }

    override suspend fun deleteTodo(id: Int) {
        // 삭제 요청은 body 없이 URL 경로를 통해 ID를 전달
        val response = client.delete("https://jsonplaceholder.typicode.com/posts/$id")

        // 보통 삭제 성공 시 200 OK 또는 204 No Content 코드를 반환
        // 여기서는 응답 상태 코드를 확인하는 로직 등을 추가할 수 있음
        println("Delete request for ID $id resulted in status: ${response.status}")
    }

}
