package com.hhp227.kotlinstudy.`08_instance_basic`

import com.hhp227.kotlinstudy.`02_instance_class`.Hero
import com.hhp227.kotlinstudy.`04_collection`.Person

fun main() {
    val person = Person("")
    val hero1 = Hero("영웅", 100)
    val hero2 = Hero("영웅", 500)

    println(hero1.toString())
    println(hero2.toString())

    println(hero1 == hero2)
}