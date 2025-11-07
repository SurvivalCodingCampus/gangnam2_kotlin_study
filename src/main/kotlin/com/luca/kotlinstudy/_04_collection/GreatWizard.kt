package com.luca.kotlinstudy._04_collection

import com.luca.kotlinstudy._02_instance_class.Hero
import com.luca.kotlinstudy._02_instance_class.CLERIC_MAX_HP


class GreatWizard(
    name: String,
    hp: Int = DEFAULT_MAX_HP,
    mp: Int = DEFAULT_MAX_MP,
    wand: Wand? = null
) : Wizard(
    name,
    hp,
    mp,
    wand,
    healAmount = DEFAULT_HEAL_AMOUNT,
    healMpCost = DEFAULT_HEAL_MP_COST,
) {
    fun superHeal(hero: Hero) {
        if (mp < DEFAULT_SUPERHEAL_MP_COST) {
            println("마나가 부족합니다.")
            return
        }
        if (hero.hp >= Hero.DEFAULT_MAX_HP) {
            return
        }
        hero.hp = Hero.DEFAULT_MAX_HP
        mp -= DEFAULT_SUPERHEAL_MP_COST
        println("슈퍼 힐을 시전했습니다. 대상 HP: ${hero.hp}")
    }

    companion object {
        const val DEFAULT_MAX_HP = 50
        const val DEFAULT_MAX_MP = 150
        const val DEFAULT_HEAL_AMOUNT = 25
        const val DEFAULT_HEAL_MP_COST = 5
        const val DEFAULT_SUPERHEAL_MP_COST = 50
    }
}