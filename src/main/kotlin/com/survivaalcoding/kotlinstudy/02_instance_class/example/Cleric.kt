package com.survivaalcoding.kotlinstudy.`02_instance_class`.example

import kotlin.math.min
import kotlin.random.Random

class Cleric(val name: String, var hp: Int = MAX_HP, var mp: Int = MAX_MP) {
    /**
     * TODO 보조 생성자를 사용해서 아래와 같이 할 수 있음. (비효율적)
     */
//class Cleric(val name: String, var hp: Int = MAX_HP, var mp: Int) {
//    constructor(name: String, hp: Int) : this(name, hp, MAX_MP)
//    constructor(name: String) : this(name, MAX_HP)

    fun selfAid() {
        if (mp < SELF_AID_MP_COST) {
            return
        }

        mp -= SELF_AID_MP_COST
        hp = min(MAX_HP, SELF_AID_HP_RECOVERY + hp)
    }

    fun pray(sec: Int = 1): Int {
        if (sec < 1) {  // TODO 예외 배우고 예외 처리
            return -1
        }

        val mpRecovery = Random.nextInt(sec, sec + 3)
        val nowMp = mp

        mp = min(MAX_MP, mp + mpRecovery)

        return mp - nowMp
    }

    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 10
        const val SELF_AID_MP_COST = 5
        const val SELF_AID_HP_RECOVERY = 10
    }
}