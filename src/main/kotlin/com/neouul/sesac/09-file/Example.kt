package com.neouul.sesac.`09-file`

import java.io.File

fun main() {
    // 파일 지정
    val file = File("docs/file/save.txt")     // 경로로 객체 생성

    // 내용 쓰기
    file.writeText("first text")
    file.writeText("Hello world!\nhi!!!")   // 내용 새로쓰기
    file.appendText("\nnext text")          // 내용 덧붙이기

    // 내용 읽기
    val text = file.readText()
    println(text)
}