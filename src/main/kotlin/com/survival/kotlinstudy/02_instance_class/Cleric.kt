package com.survival.kotlinstudy.`02_instance_class`

import kotlin.random.Random

class Cleric(var name: String, var hp: Int = 50, var mp: Int = 10) {
    val maxHp: Int = 50
    val maxMp: Int = 10

    fun selfAid() {
        if (mp < 5) return
        mp -= 5
        hp = maxHp
    }


    fun pray(time: Int): Int {
        if (time < 1 || mp == maxMp) return 0
        val randomNumber = Random.nextInt(0, 3)
        val recoveredMp = time + randomNumber
        val beforeMp = mp

        if (mp + recoveredMp > maxMp) {
            mp = maxMp
        } else {
            mp += recoveredMp
        }

        val actuallyMp = mp - beforeMp
        return actuallyMp
    }
}