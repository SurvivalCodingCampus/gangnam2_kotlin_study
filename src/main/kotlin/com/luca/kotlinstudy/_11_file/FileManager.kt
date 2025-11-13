package com.luca.kotlinstudy._11_file

import java.io.File
import java.io.FileNotFoundException

interface FileOperations {
    fun copyFile(src: File, destination: File)
}

// 테스트용 파일 만들고 -> 삭제까지
class FileManager() : FileOperations {
    override fun copyFile(src: File, destination: File) {
        try {
            val text = src.readText()
            destination.writeText(text)
        } catch (e: FileNotFoundException) {
            println("파일이 존재하지 않습니다 새롭게 생성해주세요.")
        } catch (e: Exception) {
            println("파일 복사 중 오류 발생: ${e.message}")
        }
    }

    fun write() {
        val file = File("save.txt")
        file.writeText("Hello World")
        println("생성")
    }

    fun delete(file: File) {
        if (file.exists()) {
            file.delete()
            println("삭제")
        }
    }
}