package com.luca.kotlinstudy._11_file

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class Company(val employee: Employee, val department: Department) {
    fun saveToFile() {
        try {
            val json = Json.encodeToString(this)
            File("company.txt").writeText(json)
        } catch (e: Exception) {
            println("파일 저장 중 오류 발생: ${e.message}")
            throw e
        }
    }
}

@Serializable
data class Employee(val name: String, val age: Int)

@Serializable
data class Department(val name: String, val leader: Employee)