package com.survival.kotlinstudy.`02_instance_class`

import kotlin.random.Random

class Cleric(var name: String, var hp: Int = 50, var mp: Int = 10) {

    fun selfAid() {
        if (mp < 5) return
        mp -= 5
        hp = MAX_HP
    }


    fun pray(time: Int): Int {
        if (time < 1 || mp == MAX_MP) return 0
        val randomNumber = Random.nextInt(0, 3)
        val recoveredMp = time + randomNumber
        val beforeMp = mp

        if (mp + recoveredMp > MAX_MP) {
            mp = MAX_MP
        } else {
            mp += recoveredMp
        }

        val actuallyMp = mp - beforeMp
        return actuallyMp
    }

    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 10
    }
}