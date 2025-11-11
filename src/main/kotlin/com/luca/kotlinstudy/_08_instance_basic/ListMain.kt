package com.luca.kotlinstudy._08_instance_basic

import com.luca.kotlinstudy._02_instance_class.Hero

fun main() {
    // hashCode
    val heroes = mutableListOf<Hero>() // <Int> <String> <Set>들어가는 거에 따라 값이 다르다.

    // 동일성 판단을 equals
//    val heroes = mutableListOf<String>()

    val h1 = Hero(name = "슈퍼맨", hp = 100)
    val h2 = Hero(name = "슈퍼맨", hp = 100)
//    val h1 = "10"
//    val h2 = "10"

    println(h1.toString())
    println(h2.toString())

    heroes.add(h1)
    println(heroes.size)    // 1

    heroes.remove(h2)
    println(heroes.size)    // List(0), Set(0)


    println(h1 == h2)   // equals()
    println(h1 === h2)  // 실제 주소 비교
    println(h1.equals(h2))
}