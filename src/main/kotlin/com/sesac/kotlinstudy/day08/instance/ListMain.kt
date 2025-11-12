package com.sesac.kotlinstudy.day08.instance

fun main() {
    // 동일성 판단을 equals
//    val heroes = mutableListOf<Hero>()

    // 동일성 판단을 hashCode
    val heroes = mutableSetOf<Hero>()

    val h1 = Hero("슈퍼맨", 100)
    val h2 = Hero("슈퍼맨", 100)

    println(h1.hashCode())
    println(h2.hashCode())

    heroes.add(h1)
    println(heroes.size)

    heroes.remove(h2)
    println(heroes.size)

    println(h1 == h2) // equals()
    println(h1.equals(h2))
    println(h1 === h2) // 실제 주소 비교
}
