package com.sesac.practice.day05

open class Slime(val suffix: String) {
    var hp = MAX_HP

    open fun attack(hero: Hero) {
        println("슬라임 $suffix 가 공격했다")
        println("${ATTACK_DAMAGE}의 데미지")
        hero.hp -= ATTACK_DAMAGE
    }

    companion object {
        const val MAX_HP = 50
        const val ATTACK_DAMAGE = 10
    }
}
