package com.neouul.sesac.`02-instance-class`

import kotlin.random.Random

// 1. 생성자의 파라미터 디폴트값으로 속성의 초기치를 설정한 버전
class Cleric (
    var name: String = "",
    var HP: Int = 50,
    val maxHP: Int = 50,
    var MP: Int = 10,
    val maxMP: Int = 10
) {
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