package com.survival.kotlinstudy.`07_instance_basic`

import com.survival.kotlinstudy.`02_instance_class`.Hero
import com.survival.kotlinstudy.`05_inheritance`.Slime

fun main() {
    val names = listOf("홍길동", "한석봉", "이순신")
    val sortedNames = names.sorted()
    println("!11".myFunction())

    val i: Int = 10


    val heroes = listOf<Hero>(
        Hero("홍길동"),
        Hero("한석봉"),
        Hero("이순신"),
    )

    val sortedHeros = heroes.sorted()
    println(sortedHeros)

    val monsters: List<Slime> = listOf(
        Slime("A"),
        Slime("B"),
        Slime("C"),
    )

    val sortedMonsters = monsters.sortedWith(compareBy { it.suffix })
}


fun String.myFunction(): Int {
    return 10
}