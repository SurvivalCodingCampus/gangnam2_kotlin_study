package com.hhp227.kotlinstudy.`10_file`

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

/*
연습문제
다음과 같은 코드를 작성, 실행 후 runtime error 를 발생하시오
fun main() {
    val numString = "10.5"

    val num: Int = numString.toInt()

    println(num)
}
작성한 코드를 수정하여, try-catch() 문을 사용하여 예외처리를 하시오. 예외처리에는 다음의 처리를 수행하시오.
예외가 발생하면 0으로 처리
 */

class Number {
    fun getNumber(numString: String = "10.5"): Int {
        val num: Int = try {
            numString.toInt()
        } catch (_: NumberFormatException) {
            0
        }
        return num
    }
}

/*
연습문제1 - 파일 복사 클래스 작성

다음 요구사항을 만족하는 DefaultFileOperations 클래스를 작성하시오
- 두 개의 File 객체 (원본 파일, 대상 파일)을 인자로 받아 파일을 복사하는 메서드 구현
- 파일 조작의 기본 순서에 따라 복사 로직을 처리할 것
- 원본 파일이 존재하지 않거나 복사 과정에서 오류가 발생할 경우 적절한 예외 처리 포함

interface FileOperations {
    fun copyFile(source: File, destination: File)
}

 */
interface FileOperations {
    fun copyFile(source: File, destination: File)
}

class DefaultFileOperations : FileOperations {
    override fun copyFile(source: File, destination: File) {
        if (!source.exists()) throw Exception("파일이 존재하지 않습니다.")
        if (!source.canRead()) throw Exception("파일을 읽을 수 없습니다.")
        if (!destination.exists()) destination.createNewFile()
        if (!destination.canWrite()) throw Exception("파일을 작성할 수 없습니다.")
        val readLines = source.readLines()

        for (i in readLines.indices) {
            if (i == 0) destination.writeText(readLines[i] + "\n")
            else destination.appendText(readLines[i] + "\n")
        }
    }
}

/*
연습문제
다음과 같은 사원 클래스와 부서 클래스가 있습니다.

class Employee(var name: String, var age: Int)

class Department(var name: String, var leader: Employee)

총무부 리더 ‘홍길동(41세)’의 인스턴스를 생성하고 직렬화하여 company.txt 파일에 저장하는 프로그램을 작성하시오.
직렬화를 위해 위의 2개 클래스를 일부 수정하시오.

 */

@Serializable
data class Employee(val name: String, val age: Int)

@Serializable
data class Department(val name: String, val leader: Employee)

class FileWriter {
    fun writeFile(department: Department, file: File) {
        if (!file.exists()) file.createNewFile()
        if (!file.canWrite()) throw Exception("파일을 작성할 수 없습니다.")
        val string = Json.encodeToString(department)

        file.writeText(string)
    }
}