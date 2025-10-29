package com.luca.kotlinstudy.`02_instance_class`

import kotlin.random.Random
import kotlin.time.ExperimentalTime

const val MAX_HP = 50
const val MAX_MP = 10


class Cleric(var name: String = "", var hp: Int = MAX_HP, var mp: Int = MAX_MP) {
    fun selfAid() {
        if(mp >= 5 && hp < MAX_HP ) {
            mp -= 5
            hp = MAX_HP
            println("HP: $hp, MP: $mp ")
        } else if(hp == MAX_HP) {
            println("이미 체력이 최대치입니다.")
        } else {
            println("마나가 부족합니다.")
        }
    }

    fun pray(prayTime: Int): Int {
        val oldMp = mp // 기존 mp
        var recoveryMp = mp + prayTime + Random.nextInt(0,3) // 회복
        var actualRecovery = 0 // 회복량 체크

        if(mp == MAX_MP) { // 최대치라면
            println("이미 마나가 최대치입니다.")
            return 0
        }

        if ( recoveryMp > MAX_MP ) { // 회복이 50보다 넘어설 때
            recoveryMp = MAX_MP
            actualRecovery = recoveryMp - oldMp // 회복량 체크
            mp = MAX_MP
            println("마나가 최대치로 회복 되었습니다.")
        } else {
            actualRecovery = recoveryMp - oldMp //회복량 체크
            mp = recoveryMp
            println("마나가 $actualRecovery 만큼 회복 되었습니다. 현재 MP: $mp ")
        }
        return actualRecovery
    }
}