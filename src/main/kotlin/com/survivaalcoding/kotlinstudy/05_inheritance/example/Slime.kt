package com.survivaalcoding.kotlinstudy.`05_inheritance`.example

import com.survivaalcoding.kotlinstudy.`05_inheritance`.Hero

open class Slime(val suffix: String) {
    var hp = MAX_HP

    open fun attack(hero: Hero) {
        println("슬라임 $suffix 가 공격했다")
        println("${ATTACK_POINT}의 데미지")
        hero.hp -= ATTACK_POINT
    }

    companion object {
        const val MAX_HP = 50
        const val ATTACK_POINT = 10
    }
}