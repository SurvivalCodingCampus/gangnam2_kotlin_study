package com.survivalcoding.kotlinstudy.`11_exception_file_data`

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.File
import java.io.FileNotFoundException

@Serializable
class Employee(
    var name: String,
    var age: Int,
)

@Serializable
class Department(
    var name: String,
    var leader: Employee
)


// 직렬화
fun serializeDepartment(department: Department): String {
    return Json.encodeToString(department)
}

// 파일 저장
fun saveFile(filename: String, content: String) {
    File(filename).writeText(content)
}

// 예외 처리 추가한 함수
fun jsonEncodeToString(department: Department) {
    return try {
        val json = serializeDepartment(department)  // 직렬화
        saveFile("employee.txt", json)  // 파일 저장
        println("employee.txt 저장 완료")
    } catch (e: SerializationException) {
        println("직렬화 오류: ${e.message}")
    } catch (e: FileNotFoundException) {
        println("파일 찾기 오류: ${e.message}")
    } catch (e: Exception) {
        println("예상치 못한 오류: ${e.message}")
    }
}


fun main() {
    // 인스턴스 생성
    val leader = Employee("홍길동", 41)
    val department = Department("총무부", leader)

    // 파일 저장
    jsonEncodeToString(department)
}
