package com.sesac.kotlinstudy.day10.file

import java.io.File

fun main() {
    write()
    read()
}

fun read() {
    val file = File("save.txt")

    val lines = file.readLines()

    lines.forEach {
        println(it)
    }
}

fun write() {
    val file = File("save.txt")

    // 새로 쓰기
    file.writeText("Hello World")
    file.writeText("Hello World")

    // 붙이기
    file.appendText("Hello World\n")
    file.appendText("Hello World\n")
    file.appendText("Hello World\n")
}
