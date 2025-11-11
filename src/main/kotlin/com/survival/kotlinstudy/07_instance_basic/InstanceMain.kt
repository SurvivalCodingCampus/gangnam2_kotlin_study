package com.survival.kotlinstudy.`07_instance_basic`

import com.survival.kotlinstudy.`02_instance_class`.Hero

fun main() {
    val person = Person()

    val hero = Hero("hero2",100)
    val hero2 = Hero("hero2",500)

    println(hero == hero2)

}

class Person {

}