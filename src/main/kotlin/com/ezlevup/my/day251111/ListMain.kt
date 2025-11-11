package com.ezlevup.my.day251111

import com.ezlevup.my.Hero

fun main() {
    var heroes = mutableListOf<Hero>()

    val h1 = Hero(1, 2)
    val h2 = Hero(3, 4)

    heroes.add(h1)
    println(heroes.size)

    heroes.remove(h2)
    println(heroes.size)
}
