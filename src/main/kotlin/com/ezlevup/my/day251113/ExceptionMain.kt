package com.ezlevup.my.day251113

import java.io.IOException

class Lee {
    fun readFile(path: String) {
        throw IOException("File not found")
    }
}

class Person(val name: String?)

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

fun main() {
    val lee = Lee()

    // 케이스 1: IOException 처리 시연
    try {
        lee.readFile("c:/nonexistent.txt")
    } catch (e: IOException) {
        println("파일 읽기 실패: ${e.message}")
    }

    // 케이스 2: null-safety와 fail() 함수 시연
    val person1 = Person(name = "kim")
    val s1: String = person1.name ?: fail("Name required")
    println("성공: $s1")

    // 케이스 3: fail() 함수 실제 호출 (IllegalArgumentException 발생)
    val person2 = Person(name = null)

    val s2: String = person2.name ?: fail("Name required") // 여기서 예외 발생
    println(s2) // 실행되지 않음

}
