package com.sesac.kotlinstudy.day08.instance

fun main() {
    val person = Person()

    val hero = Hero("영웅1", 100)
    val hero2 = Hero("영웅2", 200)

    println(hero.toString())
    println(hero2.toString())

    println(hero == hero2)
}

class Person : Any()

class Hero(
    var name: String,
    var hp: Int = 100,
) : Comparable<Hero> {

    fun copy(
        name: String = this.name,
        hp: Int = this.hp,
    ) = Hero(
        name = name,
        hp = hp,
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Hero

        if (hp != other.hp) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = hp
        result = 31 * result + name.hashCode()
        return result
    }

    override fun toString(): String {
        return "Hero(name='$name', hp=$hp)"
    }

    override fun compareTo(other: Hero): Int {
        if (this == other) return 0

        return this.name.compareTo(other.name)
    }
}
