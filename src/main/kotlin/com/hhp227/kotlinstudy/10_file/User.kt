package com.hhp227.kotlinstudy.`10_file`

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class User(
    val name: String,
    val email: String
)

fun main() {
    val user = User("홍길동", "abc123@naver.com")
    val jsonString = Json.encodeToString(user)

    println(jsonString)
}