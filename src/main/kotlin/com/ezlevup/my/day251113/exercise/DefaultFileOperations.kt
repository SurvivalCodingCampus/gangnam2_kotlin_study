package com.ezlevup.my.day251113.exercise

import java.io.File


interface FileOperations {
    fun copyFile(source: File, destination: File)
}


class DefaultFileOperations : FileOperations {
    override fun copyFile(source: File, destination: File) {
        if (!source.exists()) {
            throw IllegalArgumentException("source 파일이 존재하지 않습니다.")
        }

        try {
            val context = source.readText();
            destination.writeText(context)
        } catch (e: Exception) {
            throw IllegalArgumentException("파일 복사 실패 ${e.message}", e)
        }
    }
}

fun main() {
    val operation = DefaultFileOperations()
    val sourceFile = File("source1.txt")
    val destinationFile = File("destination.txt")
    operation.copyFile(sourceFile, destinationFile)
}
