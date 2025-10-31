package com.neouul.sesac.`04-collection`

fun main() {
    // List
    val nameList = mutableListOf<String>()

    nameList.add("홍길동")
    nameList.add("한석봉")
    nameList.add("신사임당")

    nameList.forEach { println(it) }

    // Set
    val lottoSet = setOf(1, 2, 3, 4)

    println(lottoSet.contains(1))
    println(lottoSet.contains(7))
}