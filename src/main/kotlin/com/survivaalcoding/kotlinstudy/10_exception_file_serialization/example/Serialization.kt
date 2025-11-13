package com.survivaalcoding.kotlinstudy.`10_exception_file_serialization`.example

import kotlinx.serialization.json.Json
import java.io.File

private const val COMPANY_TXT = "company.txt"

fun main() {
    val hong = Employee(name = "홍길동", 41)
    val department = Department("총무부 리더", hong)

    val departmentJson = Json.encodeToString(department)

    val company = File(COMPANY_TXT)
    company.writeText(departmentJson)
}