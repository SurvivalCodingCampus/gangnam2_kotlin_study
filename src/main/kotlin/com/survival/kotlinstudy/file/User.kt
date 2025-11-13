package com.survival.kotlinstudy.file

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json


@Serializable
data class User(
    val name: String,
    val email: String,
)

fun main() {
    val user = User("홍", "email.com")
    val jsonString = Json.encodeToString(user)
    println(jsonString)

    // 역직렬화
    val obj = Json.decodeFromString<User>(jsonString)
    println(obj)
}