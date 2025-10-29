package com.neouul.sesac.`02-instance-class`

import kotlin.random.Random

// 1. 생성자의 파라미터 디폴트값으로 속성의 초기치를 설정한 버전
class Cleric (
    var name: String = "",
    var hp: Int = 50,
    val maxHp: Int = 50,
    var mp: Int = 10,
    val maxMp: Int = 10
) {
    fun selfAid() {
        // MP가 5미만일 때
        if(mp < 5){
            println("현재 MP가 5보다 적어 스킬을 사용할 수 없습니다.")
            return
        }

        // HP가 이미 최대일 때
        if(hp == maxHp){
            println("현재 HP가 최대치이므로 스킬을 사용할 수 없습니다.")
            return
        }

        mp -= 5
        hp = maxHp
    }

    fun pray(sec: Int): Int {
        val recentMp = mp
        val randomNumber = Random.nextInt(3)    // 0~2 난수 생성
        mp += sec + randomNumber
        mp = if (mp > maxMp) maxMp else mp

        return mp - recentMp
    }
}