package com.survivalcoding.kotlinstudy.`07_instance_basic`

import com.survivalcoding.kotlinstudy.`02_instance_class`.Hero

fun main() {
    val person = Person()

    val hero = Hero("영웅2", 100)
    val hero2 = Hero("영웅2", 500)


    println(hero.toString())
    println(hero2.toString())

    println(hero == hero2)
}

class Person {
}