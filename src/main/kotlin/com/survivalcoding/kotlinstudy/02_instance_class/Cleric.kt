package com.survivalcoding.kotlinstudy.`02_instance_class`


class Cleric (
    var name : String,
    var hp : Int,
    var mp : Int,
    val maxHp: Int = 50,
    val maxMp: Int = 10
) {
    // 메소드 추가
    fun selfAid() {
        if (mp >= 5 ) {
            mp -= 5 // mp 5 소비
            hp = maxHp // 최대 HP 회복
        }
    }

}