package com.sesac.practice.day10.file

import java.io.File

fun interface FileOperations {
    fun copyFile(source: File, destination: File)
}
