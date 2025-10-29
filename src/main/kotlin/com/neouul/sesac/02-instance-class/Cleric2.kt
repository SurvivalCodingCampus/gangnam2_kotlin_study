package com.neouul.sesac.`02-instance-class`

import kotlin.random.Random

// 2. 바디 내부에 주어진 속성을 초기치로 선언한 버전
class Cleric2(var name: String = "") {
    var HP: Int = 50
    val maxHP: Int = 50
    var MP: Int = 10
    val maxMP: Int = 10

    // 메서드는 동일
    fun selfAid() {
        MP -= 5
        HP = maxHP
    }

    fun pray(sec: Int): Int {
        val recentMP = MP
        val randomNumber = Random.nextInt(3)    // 0~2 난수 생성
        MP += sec + randomNumber
        MP = if (MP > maxMP) maxMP else MP

        return MP - recentMP
    }
}