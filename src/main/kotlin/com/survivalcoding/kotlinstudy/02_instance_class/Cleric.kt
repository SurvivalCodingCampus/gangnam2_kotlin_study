package com.survivalcoding.kotlinstudy.`02_instance_class`

import kotlin.random.Random


const val MAX_HP = 50
const val MAX_MP = 10

class Cleric (
    // 연습문제 1 . 클래스 작성
    var name : String,
    var hp : Int = MAX_HP,
    var mp : Int = MAX_MP,
) {
    // 연습문제 2. selfAid 메소드
    fun selfAid() {
        if (mp >= 5 ) {
            mp -= 5 // mp 5 소비
            hp = MAX_HP // 최대 HP 회복
        }
    }
    // 연습 문제 3. pray 메소드
    fun pray(prayTime: Int) : Int {
        var recovery  = prayTime + Random.nextInt(3) // 회복량 보정
        var realRecovery = if (mp+ recovery > MAX_MP) {
            MAX_MP - mp // 최대 mp 보다 회복 불가
        }  else {
            recovery
        }
        mp += realRecovery
        println("${prayTime}초 기도하여 ${realRecovery} 회복 성공! 현재 MP : ${mp}")
        return realRecovery // 실제로 회복된 MP 반환
    }
}