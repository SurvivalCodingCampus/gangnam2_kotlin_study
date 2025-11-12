package com.hhp227.kotlinstudy.`08_instance_basic`

import com.hhp227.kotlinstudy.`02_instance_class`.Hero


fun main() {
    val heros = mutableListOf<Hero>()

    val h1 = Hero("슈퍼맨", 100)
    val h2 = Hero("슈퍼맨", 100)

    heros.add(h1)
    println(heros.size)

    heros.remove(h2)
    println(heros.size)
}