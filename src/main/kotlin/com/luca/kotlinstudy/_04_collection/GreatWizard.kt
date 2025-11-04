package com.luca.kotlinstudy._04_collection

import com.luca.kotlinstudy._02_instance_class.HERO_MAX_HP
import com.luca.kotlinstudy._02_instance_class.Hero
import com.luca.kotlinstudy._02_instance_class.MAX_HP

const val GREATWIZARD_MAX_MP = 150


class GreatWizard(
    name: String,
    hp: Int = MAX_HP,
    mp: Int = GREATWIZARD_MAX_MP,
    wand: Wand? = null
) : Wizard(name, hp, mp, wand) {
    override fun heal(hero: Hero) {
        if (mp <= 4) {
            println("마나가 부족합니다.")
            return
        }

        hero.hp += minOf(hero.hp +25, HERO_MAX_HP)
        mp -= 5
        println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
    }
    fun superHeal(hero: Hero){
        if (mp <= 49) {
            println("마나가 부족합니다.")
            return
        }
        if (hero.hp >= HERO_MAX_HP) {
            return
        }
        hero.hp = HERO_MAX_HP
        mp -= 50
        println("슈퍼 힐을 시전했습니다. 대상 HP: ${hero.hp}")
    }
}