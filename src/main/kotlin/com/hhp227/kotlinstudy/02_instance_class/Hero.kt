package com.hhp227.kotlinstudy.`02_instance_class`

import kotlin.random.Random

const val MAX_HP = 100

open class Hero(
    var name: String = "",
    var hp: Int = MAX_HP
) : Comparable<Hero> {
    init {
        println("Hero init")
    }

    companion object {
        var MONEY = 100

        //const val random = Random.nextInt(100) // 불가 Random.nextInt()는 런타임에 동작

        fun setRandomMoney() {
            MONEY = Random.nextInt(1000)

            //println("${name}의 소지금을 추가했다.") // 접근 불가
        }
    }

    fun attack() {
        // 로컬 변수
        hp -= 10
    }

    open fun run() {
        hp = 10
        println("Hero의 run")
    }

    fun sleep() {
        hp = 100
        println("")
    }

    fun copy(name: String = this.name, hp: Int = this.hp): Hero {
        return Hero(
            name = name,
            hp = hp
        )
    }

    override fun toString(): String {
        return "Hero(hp=$hp, name=$name)"
    }

    override fun equals(other: Any?): Boolean {
        return this.name == (other as Hero).name && this.hp == other.hp
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + hp.hashCode()
        return result
    }

    override fun compareTo(other: Hero): Int {
        if (this == other) return 0
        return this.name.compareTo(other.name)
    }
}

//f(x) = x + 4
//f(36) = 40