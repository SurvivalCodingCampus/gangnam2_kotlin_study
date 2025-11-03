package com.survivalcoding.kotlinstudy.`02_instance_class`

import kotlin.math.max
import kotlin.random.Random

fun main() {
    val hero1 = Hero(name = "홍길동", hp = 100)
    val hero2 = hero1
    hero2.hp = 200

    println(hero1.hp)

    val hero3 = Hero(name = "한석봉", hp = 50)

    Hero.MONEY = 90

    println(Hero.MONEY)

    Hero.setRandomMoney()

}

const val MAX_HP: Int = 10 // 컴파일 타임

// 동적
open class Hero(
    var name: String, // (값 == 불변)
    var hp: Int = MAX_HP,
) {

    init {
        println("1. Hero의 init")
    }

    //    // java static 정적
    companion object {
        var MONEY = 100

        const val RANDOM_MONEY = 100

        fun setRandomMoney() {
            MONEY = Random.nextInt(1000)
            this.MONEY = 100

            val hero = Hero("홍길동")
            hero.name = ""

            max(10, 100)
        }
    }

    // 멤버변수, field, 전역 변수
    // name
    // hp

    fun attack() {
        if (hp == 0) {
            return
        }
        // 로컬 변수
        hp -= 10
    }

    open fun run() {
        hp = 10
        println("Hero 의 run")
    }

    fun sleep() {
        MONEY = 200
    }
}

// f(x) = x + 4
// f(36) = 36 + 4 = 40