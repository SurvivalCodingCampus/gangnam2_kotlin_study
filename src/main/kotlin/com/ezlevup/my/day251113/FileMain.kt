package com.ezlevup.my.day251113

import java.io.File

val String.Companion.ENTER: String
    get() = "\n"

fun main() {
    var file = File("save.txt")

    // 새로 쓰기
    file.writeText("hello world")


    // 붙이기
    file.appendText("한글1")
    file.appendText(String.ENTER)
    file.appendText("한글2")
}
