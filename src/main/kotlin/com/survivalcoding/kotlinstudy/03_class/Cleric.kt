package com.survivalcoding.kotlinstudy.`03_class`

import kotlin.math.min
import kotlin.random.Random


class Cleric(
    var name: String, // 연습문제 2. 생성자 조건
    var hp: Int = MAX_HP,
    var mp: Int = MAX_MP,
) {
    fun selfAid() {
        val mpCost = 5 // mp 소비값
        when {
            mp < mpCost -> println("MP 부족! 현재 MP : ${mp}") // mp가 5 미만인경우
            hp == MAX_HP -> println("HP 최대! 회복 스킬 사용 불필요") // mp 가 최대인 경우
            else -> {
                mp -= mpCost
                hp = MAX_HP // 최대 HP 회복
                println("최대 HP 회복 성공! 현재 MP : ${mp}")
            }
        }
    }

    fun pray(prayTime: Int): Int {
        var realRecovery = 0  // 기본 기도 시간
        if (prayTime <= 0) {
            println("1초 이상 기도해주세요")
        } else {
            val recovery = prayTime + Random.nextInt(3)
            realRecovery = min(recovery, MAX_MP - mp)
            mp += realRecovery
            println("${prayTime}초 기도하여 ${realRecovery} 회복 성공! 현재 MP : ${mp}")
        }

        return realRecovery
    }

    // 연습문제 1. 필드 선언 키워드 추가
    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 10
    }
}