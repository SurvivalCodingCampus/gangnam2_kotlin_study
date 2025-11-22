package com.ezlevup.my.day251121.exercise.core

import java.io.File

object FileUtils {
    // 파일명 추출
    fun extractFileName(url: String): String {
        return url.substringAfterLast("/").substringBefore("?")
    }

    // 파일 확인
    fun isFileExists(path: String): Boolean {
        return File(path).exists()
    }

    // 파일 삭제, 성공 true
    fun deleteFile(path: String): Boolean {
        val file = File(path)
        return if (file.exists()) file.delete() else false
    }
}
