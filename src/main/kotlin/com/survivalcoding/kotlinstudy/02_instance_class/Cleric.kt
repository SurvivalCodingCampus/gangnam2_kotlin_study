package com.survivalcoding.kotlinstudy.`02_instance_class`


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

}