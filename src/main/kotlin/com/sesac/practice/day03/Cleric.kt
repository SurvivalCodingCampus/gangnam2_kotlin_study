package com.sesac.practice.day03

import kotlin.math.min
import kotlin.random.Random

class Cleric(
    val name: String,
    var hp: Int = MAX_HP,
    var mp: Int = MAX_MP,
) {
    fun selfAid() {
        if (mp < SELF_AID_MP_COST) {
            throw IllegalStateException()
        }

        mp -= SELF_AID_MP_COST
        hp = MAX_HP
    }

    fun pray(castingTime: Int = 0): Int {
        if (castingTime < 0 || castingTime > Int.MAX_VALUE - mp) {
            throw IllegalArgumentException()
        }

        val regenAmount = Random.nextInt(PRAY_MIN_REGEN_AMOUNT, PRAY_MAX_REGEN_AMOUNT + 1) + castingTime
        val originMp = mp

        mp = min(mp + regenAmount, MAX_MP)

        return mp - originMp
    }

    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 10
        const val SELF_AID_MP_COST = 5
        const val PRAY_MIN_REGEN_AMOUNT = 0
        const val PRAY_MAX_REGEN_AMOUNT = 2
    }
}
