package com.sesac.practice.day05

import kotlin.math.min

open class Wizard(
    name: String,
    mp: Int = MAX_MP,
) : Hero(name) {
    var mp = mp
        set(value) {
            require(value >= MIN_MP) { "MP는 $MIN_MP 이상이어야 합니다." }

            field = value
        }
    open val healCost: Int = HEAL_COST
    open val healAmount: Int = HEAL_AMOUNT

    init {
        this.mp = mp
    }

    fun heal(hero: Hero) {
        if (!isEnoughMp(healCost)) {
            return
        }

        mp -= healCost
        hero.hp = min(hero.hp + healAmount, MAX_HP)
        println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
    }

    protected fun isEnoughMp(cost: Int): Boolean {
        if (mp < cost) {
            println("마나가 부족합니다")
            return false
        }
        return true
    }

    companion object {
        const val MIN_MP = 0
        const val MAX_MP = 100
        const val HEAL_COST = 10
        const val HEAL_AMOUNT = 20
    }
}
