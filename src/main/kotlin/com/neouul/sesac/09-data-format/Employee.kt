package com.neouul.sesac.`09-data-format`

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

// toString 사용하려고 data class로 수정
@Serializable
data class Employee(var name: String, var age: Int)

@Serializable
data class Department(var name: String, var leader: Employee)

fun main() {
    val employee = Employee("홍길동", 41)
    val department = Department("총무부", employee)

    // 직렬화
    val json = Json.encodeToString(department)
    println(json)

    // 역직렬화
    val obj = Json.decodeFromString<Department>(json)
    println(obj)
}