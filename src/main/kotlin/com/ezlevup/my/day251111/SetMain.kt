package com.ezlevup.my.day251111

fun main() {
    var heroes = mutableSetOf<String>()

    val h1 = "10"
    val h2 = "10"

    heroes.add(h1)
    println(heroes.size)

    heroes.remove(h2)
    println(heroes.size)

}

