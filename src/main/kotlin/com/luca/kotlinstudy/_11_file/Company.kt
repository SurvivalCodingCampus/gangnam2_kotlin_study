package com.luca.kotlinstudy._11_file

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class Company(val employee: Employee, val department: Department) {
    fun saveToFile() {
        val json = Json.encodeToString(this)
        File("company.txt").writeText(json)
    }
}

@Serializable
data class Employee(val name: String, val age: Int)

@Serializable
data class Department(val name: String, val leader: Employee)