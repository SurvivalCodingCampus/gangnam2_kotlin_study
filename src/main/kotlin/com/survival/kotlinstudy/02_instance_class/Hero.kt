package com.survival.kotlinstudy.`02_instance_class`

import kotlin.random.Random

fun main() {
    // 기본 생성자
    val hero = Hero()
    val hero2 = Hero(name = "홍길동", hp = 10)
    println("test")

    Hero.MONEY = 90
    val hero3 = Hero(name = "한석봉", hp = 50)
//    hero3.money = 90
}

//동적
open class Hero(
    var name: String = "",
    var hp: Int = 0,
//    var money: Int = 0
) {
    init {
        println("Hero의 init")
    }
    //정적
    companion object {
        var MONEY = 100

        fun setRandomMoney() {
            MONEY = Random.nextInt(1000)
            this.MONEY = 100

            val hero = Hero("홍길동")
            hero.name = ""
        }
    }

    // 멤버변수, field,
    // name
    // hp

    open fun attack(slime: Slime) {
        println("$name 이 ${slime}을 공격했다.")
        println("슬라임 반격을 받았다.")
        hp -=10
    }

    open fun run() {
        hp = 10
        println("$name 이 도망침.")
    }

    fun sleep() {
        MONEY = 10

    }
}
