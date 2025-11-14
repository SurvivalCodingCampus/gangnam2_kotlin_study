package com.hhp227.kotlinstudy.`10_file`

import java.io.File

fun main() {
    write()
    read()
}

fun read() {
    val file = File("save.txt")

    val lines = file.readLines()

    for (line in lines) {
        println(line)
    }
}

fun write() {
    val file = File("save.txt")

    // 새로 쓰기
    file.writeText("Hello World\n")
    file.writeText("Hello World\n")

    //
    file.appendText("Hello World\n")
    file.appendText("Hello World\n")
    file.appendText("Hello World\n")
    file.appendText("Hello World\n")
}