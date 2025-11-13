package com.neouul.sesac.`09-file`

import java.io.File

fun main() {
    val fileA = File("a.txt")
    val fileB = File("B.txt")
    DefaultFileOperations().copyFile(fileA, fileB)
}