package com.hhp227.kotlinstudy.`02_instance_class`

import kotlin.random.Random

const val MAX_HP = 10

open class Hero(
    var name: String = "",
    var hp: Int = MAX_HP
) {
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
}

//f(x) = x + 4
//f(36) = 40