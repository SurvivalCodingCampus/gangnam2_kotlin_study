package com.sesac.practice.day05

import kotlin.math.min

open class Wizard(
    name: String,
    open var mp: Int = MAX_MP,
) : Hero(name) {
    open val healCost: Int = HEAL_COST
    open val healAmount: Int = HEAL_AMOUNT

    fun heal(hero: Hero) {
        if (mp < healCost) {
            println("마나가 부족합니다")
            return
        }

        mp -= healCost
        hero.hp = min(hero.hp + healAmount, MAX_HP)
        println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
    }

    companion object {
        const val MAX_MP = 100
        const val HEAL_COST = 10
        const val HEAL_AMOUNT = 20
    }
}
