package com.survivalcoding.kotlinstudy.`05_inheritance`

open class Hero(
    var name: String,
    var hp: Int,
    var maxHp: Int = hp  // 생성 시점의 HP를 최대 HP로 설정
) {


    fun attack(slime: Slime) {
        println("$name 이 ${slime}을 공격했다")
        println("슬라임의 반격을 받았다")
        hp -= 10
    }

    open fun run() {
        println("$name 이 도망쳤다")
    }
}
