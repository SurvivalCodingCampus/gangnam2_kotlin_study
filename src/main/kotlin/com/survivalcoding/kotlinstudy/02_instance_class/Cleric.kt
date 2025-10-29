package com.survivalcoding.kotlinstudy.`02_instance_class`

import java.sql.Time


class Cleric (
    // 연습문제 1 . 클래스 작성
    var name : String,
    var hp : Int = 50,
    var mp : Int = 10,
    val maxHp: Int = 50,
    val maxMp: Int = 10
) {
    // 연습문제 2. selfAid 메소드
    fun selfAid() {
        if (mp >= 5 ) {
            mp -= 5 // mp 5 소비
            hp = maxHp // 최대 HP 회복
        }
    }

}