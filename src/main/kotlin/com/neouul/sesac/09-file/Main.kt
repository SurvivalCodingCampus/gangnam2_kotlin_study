package com.neouul.sesac.`09-file`

import java.io.File

fun main() {
    val fileA = File("a.txt")
    val fileB = File("b.txt")

    val fileAA = File("a.txt")
    println(fileA == fileAA)
//    DefaultFileOperations().copyFile(fileA, fileAA)
    DefaultFileOperations().copyFile(fileA, fileB)
}