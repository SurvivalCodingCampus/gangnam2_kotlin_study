package com.survivaalcoding.kotlinstudy.`05_inheritance`.example

import com.survivaalcoding.kotlinstudy.`05_inheritance`.Hero

open class Wizard(
    val name: String,
    hp: Int,
    mp: Int = MAX_MP,
    var wand: Wand? = null
) {
    var hp: Int = hp
        private set

    var mp: Int = mp
        private set

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 빈 문자 혹은 공백일 수 없습니다.")
        }

        if (name.length < NAME_LENGTH_RULE) {
            throw IllegalArgumentException("이름은 ${NAME_LENGTH_RULE}자 이상이어야 합니다.")
        }

        if (hp < MIN_HP) {
            this.hp = MIN_HP
        }

        if (mp < MIN_MP) {
            throw IllegalArgumentException("MP는 최소 $MIN_MP 이상이어야 합니다.")
        }
    }

    fun useUpMp(mpCost: Int) {
        mp -= mpCost
    }

    open fun heal(hero: Hero) {
        if (this.mp < HEAL_MP_COST) {
            println("마나가 부족합니다.")
            return
        }

        hero.addHp(HEAL_HP_RECOVERY)
        useUpMp(HEAL_MP_COST)

        println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
    }

    companion object {
        const val NAME_LENGTH_RULE = 3
        const val MIN_HP = 0
        const val MAX_HP = 100
        const val MIN_MP = 0
        const val MAX_MP = 100
        const val HEAL_MP_COST = 10
        const val HEAL_HP_RECOVERY = 20
    }
}