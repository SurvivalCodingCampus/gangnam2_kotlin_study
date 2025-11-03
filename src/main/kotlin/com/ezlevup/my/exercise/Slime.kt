package com.ezlevup.my.exercise

open class Slime(
    val suffix: String,
) {
    var hp = 50

    fun attack(hero: Hero) {
        println("슬라임 $suffix 가 공격했다.")
        println("10의 데미지")
        hero.hp -= 10
    }
}