package com.luca.kotlinstudy._04_collection

import com.luca.kotlinstudy._02_instance_class.HERO_MAX_HP
import com.luca.kotlinstudy._02_instance_class.Hero
import com.luca.kotlinstudy._02_instance_class.CLERIC_MAX_HP

const val GREATWIZARD_MAX_MP = 150


class GreatWizard(
    name: String,
    hp: Int = CLERIC_MAX_HP,
    mp: Int = GREATWIZARD_MAX_MP,
    wand: Wand? = null
) : Wizard(
    name,
    hp,
    mp,
    wand,
    healAmount = HEAL_AMOUNT,
    healMpCost = HEAL_MP_COST,
) {
    fun superHeal(hero: Hero) {
        if (mp < SUPERHEAL_MP_COST) {
            println("마나가 부족합니다.")
            return
        }
        if (hero.hp >= HERO_MAX_HP) {
            return
        }
        hero.hp = HERO_MAX_HP
        mp -= SUPERHEAL_MP_COST
        println("슈퍼 힐을 시전했습니다. 대상 HP: ${hero.hp}")
    }
    companion object {
        const val HEAL_AMOUNT = 25
        const val HEAL_MP_COST = 5
        const val SUPERHEAL_MP_COST = 50
    }
}