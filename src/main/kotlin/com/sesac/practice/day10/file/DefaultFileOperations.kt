package com.sesac.practice.day10.file

import java.io.File

class DefaultFileOperations : FileOperations {
    override fun copyFile(source: File, destination: File) {
        require(source.exists() && source.isFile()) { "잘못된 원본 파일입니다." }
        require(!destination.exists() && !destination.isFile()) { "이미 존재하는 복제 파일입니다." }

        if (source.length() == 0L) {
            createEmptyFile(destination)
            return
        }

        copy(source, destination)
    }

    private fun createEmptyFile(destination: File) {
        destination.writeText("")
    }

    private fun copy(source: File, destination: File) {
        val lines = source.readLines()

        lines.forEachIndexed { index, string ->
            destination.appendText(string)
            if (index != lines.size - 1) {
                destination.appendText("\n")
            }
        }
    }
}
