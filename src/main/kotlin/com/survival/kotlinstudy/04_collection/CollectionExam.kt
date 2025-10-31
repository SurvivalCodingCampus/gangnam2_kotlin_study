package com.survival.kotlinstudy.`04_collection`

fun main() {
    val names = mutableListOf<Int>()
    names.add(10)

    val name2 = listOf<Int>(1, 2, 3, 4)
    println(name2[0])

    name2.forEach(::println)
    val gildong = mapOf(
//        "name".to("홍길동"),
        "name" to "홍길동",
        "age" to 10
    )
}