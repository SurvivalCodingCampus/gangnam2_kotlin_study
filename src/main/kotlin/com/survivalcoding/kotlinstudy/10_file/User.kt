package com.survivalcoding.kotlinstudy.`10_file`

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class User(
    val name: String,
    val email: String,
)

fun main() {
    val user = User("홍길동", "aa@aa.com")

    val jsonString = Json.encodeToString(user)

    println(jsonString)

    // 역직렬화 : json 형태의 String 을 객체로

    val obj = Json.decodeFromString<User>(jsonString)
    println(obj)

}