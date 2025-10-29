package com.sesac.practice.day02

import kotlin.math.min
import kotlin.random.Random

class Cleric(val name: String, var hp: Int = 50, var mp: Int = 10) {
    val maxHp: Int = 50
    val maxMp: Int = 10

    fun selfAid() {
        val selfAidMp = 5

        if (mp < selfAidMp) {
            return
        }

        mp -= selfAidMp
        hp = maxHp
    }

    fun pray(castingTime: Int = 0): Int {
        if (castingTime < 0) {
            return 0
        }

        val regenAmount = Random.nextInt(3) + castingTime
        val originMp = mp

        mp = min(mp + regenAmount, maxMp)

        return mp - originMp
    }
}
