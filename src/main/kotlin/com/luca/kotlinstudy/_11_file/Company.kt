package com.luca.kotlinstudy._11_file

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class Company(val department: Department) {
    fun saveToFile() {
        try {
            val json = Json.encodeToString(department)
            File("company.txt").writeText(json)
            println(json)
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

fun main(){
    val e = Employee("홍길동",41)
    val d = Department("총무부",e)
    val c = Company(d)
    println(c)
}