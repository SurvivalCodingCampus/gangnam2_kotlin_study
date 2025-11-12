package com.hhp227.kotlinstudy.`08_instance_basic`

import com.hhp227.kotlinstudy.`02_instance_class`.Hero
import com.hhp227.kotlinstudy.`05_inheritance`.Slime
import kotlin.collections.sorted

fun main() {
    val names = listOf("홍길동", "한석봉", "이순신")
    val sortedNames = names.sorted()

    println(names)
    println(sortedNames)

    val heros = listOf(Hero("홍길동"), Hero("한석봉"), Hero("이순신"))
    val sotedHeros = heros.sorted()

    println(sotedHeros)

    val monsters: List<Slime> = listOf(Slime("A"), Slime("B"))

    val sortedMonsters = monsters.sortedWith { a, b -> a.suffix.compareTo(b.suffix) }
    
    println(sortedMonsters)
}