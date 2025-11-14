package com.survivalcoding.kotlinstudy.`11_file`.practice

import java.io.File

/*
다음 요구사항을 만족하는 DefaultFileOperations 클래스를 작성하시오

1) 두 개의 File 객체 (원본 파일, 대상 파일)을 인자로 받아 파일을 복사하는 메서드 구현
2) 파일 조작의 기본 순서에 따라 복사 로직을 처리할 것
3) 원본 파일이 존재하지 않거나 복사 과정에서 오류가 발생할 경우 적절한 예외 처리 포함
*/

interface FileOperations {
    fun copyFile(source: File, destination: File)
    fun copyFileSafely(source: File, destination: File): Boolean
    fun deleteFile(source: File? = null, destination: File? = null)
}

class DefaultFileOperations : FileOperations {

    override fun copyFile(source: File, destination: File) {
        val text = source.readText()
        destination.writeText(text)
    }

    override fun copyFileSafely(source: File, destination: File): Boolean {
        try {
            copyFile(source, destination)
            return true
        } catch (e: Exception) {
            println("${e.message}")
            return false
        }
    }

    override fun deleteFile(source: File?, destination: File?) {
        source?.delete()
        destination?.delete()
    }
}