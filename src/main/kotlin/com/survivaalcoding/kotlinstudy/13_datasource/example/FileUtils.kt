package com.survivaalcoding.kotlinstudy.`13_datasource`.example

import java.io.File
import java.io.FileNotFoundException

abstract class FileUtils {
    companion object {
        fun getFileText(path: String): String {
            val file = File(path)
            validateFile(file)

            return file.readText()
        }

        private fun validateFile(file: File) {
            if (!file.exists()) {
                throw FileNotFoundException("파일이 존재하지 않습니다.")
            }
            if (file.isDirectory()) {
                throw IllegalStateException("디렉토리는 읽을 수 없습니다.")
            }
        }
    }
}