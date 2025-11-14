package com.ezlevup.my.day251113.exercise

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class Employee(
    var name: String,
    var age: Int,
) {}

@Serializable
data class Department(
    var name: String,
    var leader: Employee,
) {}

class FileManager {
    fun save(filename: String, content: String) {
        File(filename).writeText(content)
    }

    fun delete(filename: String) {
        File(filename).delete()
    }

    fun load(filename: String): String {
        return File(filename).readText()
    }
}

fun main() {
    val employee = Employee("홍길동", 41)
    val jsonString = Json.encodeToString(employee)
    println(jsonString)

    val department = Department("총무부", employee)
    val jsonDepartment = Json.encodeToString(department)
    println(jsonDepartment)

    FileManager().save("company.txt", jsonDepartment)

    val loadFile: String = FileManager().load("company.txt")
    val department2 = Json.decodeFromString<Department>(loadFile)
    println(department2)

    FileManager().delete("company.txt")
}

