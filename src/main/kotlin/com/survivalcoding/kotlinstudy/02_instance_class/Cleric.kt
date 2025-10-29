package com.survivalcoding.kotlinstudy.`02_instance_class`

import kotlin.random.Random


class Cleric(
    var name: String,
    var hp: Int = 50,
    val maxHp: Int = 50,
    var mp: Int = 10,
    val maxMp: Int = 10
) {
    fun selfAid(){
        if(mp >= 5){
            mp -= 5
            hp = maxHp
        }
    }

    fun pray(time: Int): Int {
        val mpRecovery = time + Random.nextInt(0, 3)
        if((mp + mpRecovery) < maxMp) {
            mp += mpRecovery
        } else {
            val actualRecovery = maxMp - mp
            mp = maxMp
            return actualRecovery
        }
        return mpRecovery
    }
}