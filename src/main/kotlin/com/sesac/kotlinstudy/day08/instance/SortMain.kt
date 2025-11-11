package com.sesac.kotlinstudy.day08.instance

fun main() {
    val names = listOf("홍길동", "한석봉", "이순신")

    val sortedNames = names.sorted()

    println(names)
    println(sortedNames)

    println("111".myFunction())

    val heroes = listOf(
        Hero("홍길동"),
        Hero("한석봉"),
        Hero("이순신"),
    )

    val sortedHeroes = heroes.sorted()
    println(sortedHeroes)

    val monsters = listOf(
        Slime("A"),
        Slime("B"),
    )

    val sortedMonsters = monsters.sortedWith { a, b -> a.name.compareTo(b.name) }
    println(sortedMonsters)
}

fun String.myFunction(): Int {
    return 10
}

data class Slime(
    val name: String,
) {
    override fun toString(): String {
        return "Slime(name='$name')"
    }
}
