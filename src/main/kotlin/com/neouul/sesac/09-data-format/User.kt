package com.neouul.sesac.`09-data-format`

import  kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
data class User(
    val name: String,
    val email: String,
)

fun main() {
    // 직렬화
    val json = Json.encodeToString(User("홍길동", "aaa@email.com"))
    println(json)

    // 역직렬화
    val obj = Json.decodeFromString<User>(json)
    println(obj)
}