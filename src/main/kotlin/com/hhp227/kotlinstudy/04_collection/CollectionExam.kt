package com.hhp227.kotlinstudy.`04_collection`

fun main() {
    // 수정 가능한 리스트
    val names1: MutableList<Int> = mutableListOf<Int>()
    names1.add(10)

    // 수정 불가능한 리스트
    val names2: List<Int> = listOf<Int>(1, 2, 3, 4)
    println(names2[5])

    val names3: Array<Int> = arrayOf(1, 2, 3, 4)
    names3[0] = 10
}