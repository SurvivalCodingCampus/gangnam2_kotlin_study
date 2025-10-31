package com.luca.kotlinstudy._04_collection


fun main() {
    // 수정 가능한 리스트
    val names: MutableList<Int> = mutableListOf<Int>()
    names.add(10)

    // 수정 불가능한 리스트
    val names2: List<Int> = listOf<Int>(1, 2, 3, 4)
    println(names2[3])

    // Array
    val names3: Array<Int> = arrayOf(1, 2, 3, 4)
    names3[0] = 10

    // Map을 자바에서는
    // val namePair: Pair<String, String> = Pair("name", "홍길동")

    // Map
    val gildong = mapOf(
        //"name".to("홍길동),
        "name" to "홍길동",
        "age" to 10
    )
    println(gildong["name"]) // Map 호출 방법
}

// Map 보다는 이렇게 클래스 만들어서 사용하는 게 좋다.
class Person(
    val name: String,
    val age: Int
)