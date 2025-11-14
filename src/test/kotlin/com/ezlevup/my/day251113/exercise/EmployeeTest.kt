package com.ezlevup.my.day251113.exercise

import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File
import kotlin.test.assertTrue

class EmployeeTest {
    @Test
    fun `직원 생성자`() {
        // given
        val name = "홍길동"
        val age = 41
        val employee: Employee = Employee(name, age)

        // when & then
        assertEquals(name, employee.name)
        assertEquals(age, employee.age)
    }

    @Test
    fun `부서 생성자`() {
        // given
        val name = "홍길동"
        val age = 41
        val departmentName = "총무부"
        val employee: Employee = Employee(name, age)
        val department: Department = Department(departmentName, employee)

        // when & then
        assertEquals(name, department.leader.name)
        assertEquals(age, department.leader.age)
        assertEquals(departmentName, department.name)
    }

    @Test
    fun `직원 직렬화`() {
        // given
        val name = "홍길동"
        val age = 41
        val employee: Employee = Employee(name, age)

        // when
        val json = Json.encodeToString(employee)

        // than
        val expected = """{"name":"$name","age":$age}"""
        assertEquals(json, expected)
    }

    @Test
    fun `부서 직렬화`() {
        // given
        val name = "홍길동"
        val age = 41
        val departmentName = "총무부"
        val employee: Employee = Employee(name, age)
        val department: Department = Department(departmentName, employee)

        // when
        val json = Json.encodeToString(department)

        // than
        val expected = """{"name":"$departmentName","leader":{"name":"$name","age":$age}}"""
        assertEquals(json, expected)
    }

    @Test
    fun `부서 직렬화 파일 저장`() {
        // given
        val name = "홍길동"
        val age = 41
        val departmentName = "총무부"
        val employee: Employee = Employee(name, age)
        val department: Department = Department(departmentName, employee)

        // when
        val json = Json.encodeToString(department)
        FileManager().save("company.txt", json)

        // than
        val expected = """{"name":"$departmentName","leader":{"name":"$name","age":$age}}"""
        val loadFile: String = FileManager().load("company.txt")
        assertEquals(expected, loadFile)

        // 테스트 파일 정리
        File("company.txt").delete()
    }

    @Test
    fun `부서 역직렬화 파일 저장`() {
        // given
        val name = "홍길동"
        val age = 41
        val departmentName = "총무부"
        val employee: Employee = Employee(name, age)
        val department: Department = Department(departmentName, employee)

        // when
        val json = Json.encodeToString(department)
        FileManager().save("company.txt", json)

        // than
        val expected = """{"name":"$departmentName","leader":{"name":"$name","age":$age}}"""
        val loadFile: String = FileManager().load("company.txt")
        assertEquals(expected, loadFile)

        val department2 = Json.decodeFromString<Department>(loadFile)
        assertEquals(departmentName, department2.name)
        assertEquals(name, department2.leader.name)
        assertEquals(age, department2.leader.age)
    }

}

class FileManagerTest {
    @Test
    fun `파일매니저 생성장`() {
        // giver
        val fileManager: FileManager = FileManager()

        // when & then
    }

    @Test
    fun `파일매니저 파일 생성`() {
        // giver
        val fileManager: FileManager = FileManager()

        // when
        val fileName = "test.txt"
        val content = "test"
        fileManager.save(fileName, content)

        // then
        val isFileExist: Boolean = File(fileName).exists()
        assertTrue(isFileExist)

        // 파일 삭제
        val isDeleted = File(fileName).delete()
        assertTrue(isDeleted)
    }
}
