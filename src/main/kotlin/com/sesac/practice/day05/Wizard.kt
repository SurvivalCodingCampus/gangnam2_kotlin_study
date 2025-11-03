package com.sesac.practice.day05

import kotlin.math.min

class Wizard(
    name: String,
    var mp: Int = MAX_MP,
) : Hero(name) {
    fun heal(hero: Hero) {
        if (mp < HEAL_COST) {
            println("마나가 부족합니다")
            return
        }

        mp -= HEAL_COST
        hero.hp = min(hero.hp + HEAL_AMOUNT, MAX_HP)
        println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
    }

    companion object {
        const val MAX_MP = 100
        const val HEAL_COST = 10
        const val HEAL_AMOUNT = 20
    }
}
