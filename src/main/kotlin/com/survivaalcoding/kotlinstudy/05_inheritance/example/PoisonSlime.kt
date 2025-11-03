package com.survivaalcoding.kotlinstudy.`05_inheritance`.example

import com.survivaalcoding.kotlinstudy.`05_inheritance`.Hero

class PoisonSlime(suffix: String) : Slime(suffix) {
    var poisonCount = AVAILABLE_POISON_ATTACK_COUNT

    override fun attack(hero: Hero) {
        if (!hero.isAvailableAttack()) {
            return
        }

        println("슬라임 $suffix 가 공격했다")
        println("${ATTACK_POINT}의 데미지")
        hero.hp -= if (hero.hp - ATTACK_POINT >= 0) ATTACK_POINT else hero.hp

        if (poisonCount == UNAVAILABLE_POISON_ATTACK_COUNT
            || !hero.isAvailableAttack()) {
            return
        }

        println("추가로, 독 포자를 살포했다!")
        val damage = Hero.MAX_HP / POISON_ATTACK_POINT
        println("$damage 포인트의 데미지")

        hero.hp -= damage
        poisonCount--
    }

    companion object {
        const val UNAVAILABLE_POISON_ATTACK_COUNT = 0
        const val AVAILABLE_POISON_ATTACK_COUNT = 5
        const val POISON_ATTACK_POINT = 5
    }
}