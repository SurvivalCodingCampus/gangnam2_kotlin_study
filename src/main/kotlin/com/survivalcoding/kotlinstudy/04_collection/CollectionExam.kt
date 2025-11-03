package com.survivalcoding.kotlinstudy.`04_collection`

fun main() {
    // 수정 가능한 리스트
    val names: MutableList<Int> = mutableListOf<Int>()
    names.add(10)

    // 수정 불가능한 리스트
    val names2: List<Int> = listOf<Int>(1, 2, 3, 4)
    println(names2[3])

    val names3: Array<Int> = arrayOf(1, 2, 3, 4)
    names3[0] = 10

    val namePair: Pair<String, String> = Pair("name", "홍길동")

    val gildong = mapOf(
        "name".to("홍길동"),
        "age" to 10
    )

    println(gildong["name"])
    println(gildong["ageeee"])  // null
}

class Person(
    val name: String,
    val age: Int
)