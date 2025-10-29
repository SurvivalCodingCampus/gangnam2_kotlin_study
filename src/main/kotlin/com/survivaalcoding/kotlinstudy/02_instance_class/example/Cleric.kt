package com.survivaalcoding.kotlinstudy.`02_instance_class`.example

import kotlin.random.Random

class Cleric(val name: String, var hp: Int = 50, var mp: Int = 10) {
    val maxHp: Int = 50
    val maxMp: Int = 10

    fun selfAid() {
        val mpCost = 5
        val recovery = 10

        if (mp < mpCost) {
            println("mp가 부족합니다. 현재 mp: $mp")
            return
        }

        hp = if (hp + recovery > maxHp) maxHp else hp + recovery

        mp -= mpCost
        println("회복 스킬을 사용해 mp가 $mpCost 감소합니다. 현재 hp: $hp, mp: $mp")
    }

    fun pray(sec: Int = 1): Int {
        val mpRecovery = Random.nextInt(sec, sec + 3)
        var result = 0

        if (mp + mpRecovery > maxMp) {
            result = maxMp - mp
            mp = maxMp
        } else {
            result = mpRecovery
            mp += mpRecovery
        }

        println("mp를 $result 회복했습니다. 현재 mp: $mp")

        return result
    }
}