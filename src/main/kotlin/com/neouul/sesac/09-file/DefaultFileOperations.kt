package com.neouul.sesac.`09-file`

import java.io.File
import java.io.FileNotFoundException

class DefaultFileOperations : FileOperations {
    override fun copyFile(source: File, destination: File) {
        try {
            // 원본 파일과 대상 파일의 경로가 같은 경우 예외 던짐 (복사가 의미 없음)
            require(source != destination) { "${source} (원본 파일과 대상 파일이 같습니다)" }

            val string = source.readText()
            destination.writeText(string)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()

            print("대상 파일의 경로를 입력해 주세요\nsource: ")
            copyFile(source, inputPath())
        } catch (e: FileNotFoundException) {
            e.printStackTrace()

            print("원본 파일의 경로를 입력해 주세요\nsource: ")
            copyFile(inputPath(), destination)
        }
    }

    private fun inputPath(): File {
        val path = readln()     // null 입력되면 터짐
        return File(path)
    }
}