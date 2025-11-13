package com.neouul.sesac.`09-file`

import java.io.File
import java.io.FileNotFoundException

class DefaultFileOperations : FileOperations {
    override fun copyFile(source: File, destination: File) {
        try {
            val string = source.readText()
            destination.writeText(string)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()

            print("원본 파일의 경로를 입력해주세요\nsource: ")
            val path = readln()     // null 입력되면 터짐
            val newSource = File(path)
            copyFile(newSource, destination)
        }
    }
}