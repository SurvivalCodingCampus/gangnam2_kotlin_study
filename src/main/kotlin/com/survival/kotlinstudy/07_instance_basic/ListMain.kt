package com.survival.kotlinstudy.`07_instance_basic`

import com.survival.kotlinstudy.`02_instance_class`.Hero

fun main() {
//    val heroes = mutableListOf<Hero>()
    val heroes = mutableSetOf<Hero>()
    val h1 = Hero("슈퍼맨",100)
    val h2 = Hero("슈퍼맨",100)

    heroes.add(h1)
    println(heroes.size)
    heroes.remove(h2)
    println(heroes.size)
}