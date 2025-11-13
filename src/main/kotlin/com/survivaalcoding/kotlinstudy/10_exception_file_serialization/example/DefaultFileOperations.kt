package com.survivaalcoding.kotlinstudy.`10_exception_file_serialization`.example

import java.io.File

class DefaultFileOperations : FileOperations {
    override fun copyFile(source: File, destination: File) {
        if (!source.exists()) {
            throw IllegalStateException("원본 파일이 존재하지 않습니다.")
        }
        if (!source.canRead()) {
            throw IllegalStateException("원본 파일에 접근할 수 없습니다.")
        }

        if (destination.exists() && !destination.canWrite()) {
            throw IllegalStateException("복사할 파일에 쓰기 권한이 없습니다.")
        }

        source.readLines().forEach {
            destination.appendText("${it}\n", Charsets.UTF_8)
        }
    }
}