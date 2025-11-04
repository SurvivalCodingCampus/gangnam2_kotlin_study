package com.survival.kotlinstudy.`05_inheritance`

import com.survival.kotlinstudy.`02_instance_class`.Hero
import com.survival.kotlinstudy.`03_encapsulation`.Wand
import com.survival.kotlinstudy.`03_encapsulation`.Wizard

class GreatWizard(
    name: String,
    hp: Int,
    wand: Wand?
) : Wizard(name, hp, wand, mp = INIT_MP) {

    override fun heal(hero: Hero) {
        if (mp < HEAL_COST) {
            println("마나가 부족합니다.")
            return
        }
        hero.hp += HEAL_HP
        mp -= HEAL_COST
        println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
    }

    fun superHeal(hero: Hero) {
        if (mp < SUPER_HEAL_COST) {
            println("마나가 부족합니다.")
            return
        }
        hero.hp = Hero.MAX_HP
        mp -= SUPER_HEAL_COST
        println("슈퍼 힐을 시전했습니다. 대상 HP : ${hero.hp}")
    }

    companion object {
        const val INIT_MP = 150
        const val HEAL_COST = 5
        const val SUPER_HEAL_COST = 50
        const val HEAL_HP = 25
    }
}