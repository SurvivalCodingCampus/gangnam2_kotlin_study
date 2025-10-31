package com.sesac.kotlinstudy.day04.collection

fun main() {
    // 수정 가능한 리스트
    val names: MutableList<Int> = mutableListOf()
    names.add(10)

    // 수정 불가능한 리스트
    val names2: List<Int> = listOf(1, 2, 3, 4)
//    names2.add(10)

    val name3: Array<Int> = arrayOf(1, 2, 3, 4)
    name3[0] = 10
    println(name3[0])

    val gildong: Map<String, Any> = mapOf(
        "name".to("홍길동"),
        "age" to 20,
    )
    println(gildong["name"])
    println(gildong["ageeee"]) // null
}

class Person(
    val name: String,
    val age: Int,
)
