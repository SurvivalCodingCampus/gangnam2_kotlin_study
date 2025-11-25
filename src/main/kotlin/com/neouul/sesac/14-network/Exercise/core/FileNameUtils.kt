package com.neouul.sesac.`14-network`.Exercise.core

fun String.toFileNameFromUrl(): String {
    // 1. 쿼리 스트링 제거 (? 앞부분만 자름)
    val urlWithoutQuery = this.substringBefore("?")

    // 2. 마지막 슬래시(/) 뒤의 내용 가져오기
    val fileName = urlWithoutQuery.substringAfterLast("/")

    // 3. 만약 확장자가 없다면 강제로 붙여주기 (선택사항)
    return if (fileName.contains(".")) fileName else "$fileName.jpg"
}

fun makeFileNmae(directory: String, name: String): String {
    if (directory.last() == '/') {
        return directory + name
    } else {
        return "$directory/$name"
    }
}