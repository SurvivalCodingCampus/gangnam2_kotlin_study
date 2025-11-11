package com.survivaalcoding.kotlinstudy.`08_instance_basic`

fun main() {
    val heroes = mutableListOf<Hero>()

    val hero1 = Hero("슈퍼맨")
    val hero2 = Hero("슈퍼맨")

    heroes.add(hero1)
    println(heroes.size)    // 1

    heroes.remove(hero2)
    println(heroes.size)    // 0

    heroes.sortedWith { a, b -> a.name.compareTo(b.name) }
    heroes.sortedWith(compareBy { it.name })
    heroes.sortedBy { it.name }

    val person1 = Person("홍", 10)
    val person2 = person1.copy()
    println(person1)
    println(person2)
    println(person1 === person2)
}