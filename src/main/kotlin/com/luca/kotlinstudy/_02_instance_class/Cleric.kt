package com.luca.kotlinstudy._02_instance_class

import kotlin.random.Random

class Cleric(
    var name: String,
    var hp: Int = DEFAULT_MAX_HP,
    var mp: Int = DEFAULT_MAX_MP,
) {
    fun selfAid() {
        if (mp >= SELF_AID_MP_COST && hp < DEFAULT_MAX_HP) {
            mp -= SELF_AID_MP_COST
            hp = DEFAULT_MAX_HP
        }
//            println("HP: $hp, MP: $mp ")
//        } else if (hp == MAX_HP) {
//            println("이미 체력이 최대치입니다.")
//        } else {
//            println("마나가 부족합니다.")
//        }
    }

    fun pray(prayTime: Int): Int {
        val oldMp = mp // 기존 MP
        var recoveryMp = 0 // 회복 후 MP

        if (mp == DEFAULT_MAX_MP) return 0 // 최대치
        /*
                if (mp == MAX_MP) { // 최대치라면
                    println("이미 마나가 최대치입니다.")
                    return 0
                }
        */
        val recoveryAmount = prayTime + Random.nextInt(0, 3) // 회복할 양
        recoveryMp = mp + recoveryAmount

        if (recoveryMp > DEFAULT_MAX_MP) { // 회복이 최대치를 넘을 때
            recoveryMp = DEFAULT_MAX_MP
        }
        val actualRecovery = recoveryMp - oldMp //(회복량 체크)
        mp = recoveryMp

//        if (mp == MAX_MP) {
//            println("마나가 최대치로 회복 되었습니다. 현재 MP: $mp ")
//        } else {
//            println("마나가 $actualRecovery 만큼 회복 되었습니다. 현재 MP: $mp ")
//        }
        return actualRecovery
    }

    companion object {
        const val DEFAULT_MAX_HP = 50
        const val DEFAULT_MAX_MP = 10
        const val SELF_AID_MP_COST = 5
    }
}