package com.survival.kotlinstudy.file

import java.io.File
import java.io.FileNotFoundException

class DefaultFileOperations : FileOperations {
    override fun copyFile(source: File, destination: File) {
        try {
            val content = source.readText()
            destination.writeText(content)
        } catch (e: FileNotFoundException) {
            println("파일을 찾을 수 없습니다")
        } catch (e: Exception) {
            println("파일 복사 중 오류가 발생했습니다: ${e.message}")
        }
    }
}
