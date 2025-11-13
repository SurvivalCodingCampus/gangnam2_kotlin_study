package com.luca.kotlinstudy._11_file

import java.io.File

fun main() {
}

// 파일이 없을 때 읽으면 터진다. 그럴 때는 try catch
fun read() {
    val file = File("save.txt")

    val lines: List<String> = file.readLines()

    lines.forEach {
        println(it)
    }
}

fun write() {
    val file = File("save.txt")

    file.writeText("Hello World") // 새로쓰는거
    file.writeText("Hello World")

    file.appendText("Hello World\n") // 붙이기
}