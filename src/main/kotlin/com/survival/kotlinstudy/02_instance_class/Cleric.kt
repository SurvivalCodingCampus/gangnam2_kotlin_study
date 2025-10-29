package com.survival.kotlinstudy.`02_instance_class`

import kotlin.random.Random

class Cleric(var name: String, var hp: Int, var mp: Int) {
    val maxHp: Int = 50
    val maxMp: Int = 50

    fun selfAid() {
        if (mp < 5) return
        else {
            mp -= 5
            hp = maxHp
        }
    }


    fun pray(time: Int): Int {
        val randomNumber = Random.nextInt(0, 3)
        val recoveredMp = time + randomNumber
        return if (maxMp < mp + recoveredMp) maxMp - mp else recoveredMp
    }
}