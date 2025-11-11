package com.luca.kotlinstudy._08_instance_basic

import com.luca.kotlinstudy._02_instance_class.Hero
import com.luca.kotlinstudy._05_inheritance.Slime
import kotlin.collections.sorted

fun main() {
    val names: List<String> = listOf("홍길동", "한석봉", "이순신")
    val sortedNames = names.sorted()

    val i: Int = 10

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

    val sortedMonsters = monsters.sortedWith { a, b -> -a.suffix.compareTo(b.suffix) }
    println(sortedMonsters)
}

fun String.myFunction(): Int {
    return 10
}