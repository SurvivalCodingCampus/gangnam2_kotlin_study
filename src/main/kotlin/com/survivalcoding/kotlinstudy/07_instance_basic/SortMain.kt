package com.survivalcoding.kotlinstudy.`07_instance_basic`

import com.survivalcoding.kotlinstudy.`02_instance_class`.Hero
import com.survivalcoding.kotlinstudy.`02_instance_class`.Slime
import kotlin.collections.sorted

fun main() {
    val names: List<String> = listOf("홍길동", "한석봉", "이순신")
    val sortedNames = names.sorted()

    val i : Int = 10

    println(names)
    println(sortedNames)

    println("111".myFunction())

    val heroes: List<Hero> = listOf(
        Hero("홍길동"),
        Hero("한석봉"),
        Hero("이순신"),
    )
    val sortedHeroes = heroes.sorted()
    println(sortedHeroes)

    val monsters: List<Slime> = listOf(
        Slime("B"),
        Slime("A"),
    )

    val sortedMonsters = monsters.sortedWith { a, b -> -a.name.compareTo(b.name) }
    println(sortedMonsters)
}

fun String.myFunction(): Int {
    return 10
}