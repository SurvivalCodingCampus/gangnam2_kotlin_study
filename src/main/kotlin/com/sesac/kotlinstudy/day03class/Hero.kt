package com.sesac.kotlinstudy.day03class

import kotlin.random.Random

fun main() {
    val hero1 = Hero(name = "홍길동", hp = 100)
    val hero2 = hero1
    hero2.hp = 200

    println(hero1.hp)

    val hero3 = Hero(name = "한석봉")

    Hero.money = 90

    println(hero3.money())
}

// 동적
class Hero(
    var name: String = "",
    var hp: Int = 0,
) {
    fun sleep() {
        // Hero.money = 200
        money = 200
    }

    fun money(): Int {
        return money
    }

    // java static 정적
    companion object {
        var money = 100

//        const val randomMoney = 100
//        val randomMoney = Random.nextInt(1000)

        fun setRandomMoney() {
            money = Random.nextInt(1000)
            // name, hp 접근 불가
        }
    }
}
