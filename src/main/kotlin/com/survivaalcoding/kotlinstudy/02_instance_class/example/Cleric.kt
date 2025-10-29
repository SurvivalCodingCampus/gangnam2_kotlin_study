package com.survivaalcoding.kotlinstudy.`02_instance_class`.example

import kotlin.random.Random

class Cleric(val name: String, var hp: Int = 50, var mp: Int = 10) {
    val maxHp: Int = 50
    val maxMp: Int = 10

    fun selfAid() {
        if (mp < 5) {
            println("mp가 부족합니다. 현재 mp: $mp")
            return
        }

        if (hp >= maxHp) {
            println("hp가 최대입니다.")
            return
        }

        val hpRecovery = 10
        val mpCost = 5

        mp -= mpCost
        hp += hpRecovery
        println("회복 스킬을 사용해 mp가 $mpCost 감소하고, hp가 $hpRecovery 증가합니다.")
        println("현재 hp: $hp, mp: $mp")
    }

    fun pray(sec: Int = 1): Int {
        if (mp >= maxMp) {
            println("mp가 최대입니다.")
            return 0
        }

        val mpRecovery = Random.nextInt(sec, sec + 3)
        mp += mpRecovery
        
        println("mp를 $mpRecovery 회복했습니다.")
        println("현재 mp: $mp")

        return mpRecovery
    }
}