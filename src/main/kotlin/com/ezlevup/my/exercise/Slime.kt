package com.ezlevup.my.exercise

open class Slime(
    val suffix: String, // 구분자
) {
    var hp = 50

    open fun attack(hero: Hero) {
        println("슬라임 $suffix 가 공격했다.")
        println("10의 데미지")
        hero.takeDamage(10)
    }
}
