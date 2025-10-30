package com.neouul.sesac.`02-instance-class`

import kotlin.random.Random

// 2. 바디 내부에 주어진 속성을 초기치로 선언한 버전
class Cleric2(var name: String = "") {
    var hp: Int = 50
    val maxHp: Int = 50
    var mp: Int = 10
    val maxMp: Int = 10

    // 메서드는 동일
    fun selfAid() {
        require(mp >= 5) { "MP가 부족합니다. 현재 MP: $mp" }
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