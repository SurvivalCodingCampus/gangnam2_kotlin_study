package com.survival.kotlinstudy.file

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
class Department(var name: String, var leader: Employee)


fun main() {
    val file = File("company.txt")
    val employee = Employee(name = "홍길동", age = 41)
    val leader = Department(name = "총무부", leader = employee)

    val leaderString = Json.encodeToString(leader)
    file.writeText(leaderString)

    println(file.readText())
}