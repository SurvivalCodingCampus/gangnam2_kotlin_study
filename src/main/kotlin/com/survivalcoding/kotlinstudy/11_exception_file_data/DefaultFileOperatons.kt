package com.survivalcoding.kotlinstudy.`11_exception_file_data`

import java.io.File
import java.io.FileNotFoundException

interface FileOperations {
    fun copyFile(source: File, destination: File)
}

class DefaultFileOperations : FileOperations {
    override fun copyFile(source: File, destination: File) {
        try {
            // 원본 파일 존재 여부 확인
            if (!source.exists()) {
                throw FileNotFoundException("원본 파일 없음: ${source.path}")
            }

            // 파일 복사
            val text = source.readText()
            destination.writeText(text)

            // 이렇게 하면 한줄로 끝
            // source.copyTo(destination, overwrite = true)    // overwrite: 파일이 존재하면 덮어쓰기

            println("복사 완료: ${source.path} -> ${destination.path}")

        } catch (e: Exception) {
            println("파일 복사 중 오류 발생: ${e.message}")
            e.printStackTrace()
        }
    }
}
