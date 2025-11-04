package com.survivaalcoding.kotlinstudy.`05_inheritance`.example

import com.survivaalcoding.kotlinstudy.`05_inheritance`.Hero

class GreatWizard(name: String, hp: Int, mp: Int = MAX_MP) : Wizard(name, hp, mp) {
    override fun heal(hero: Hero) {
        if (this.mp < HEAL_MP_COST) {
            println("마나가 부족합니다.")
            return
        }

        hero.addHp(HEAL_HP_RECOVERY)
        super.useUpMp(HEAL_MP_COST)

        println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
    }

    fun superHeal(hero: Hero) {
        if (this.mp < SUPER_HEAL_MP_COST) {
            println("마나가 부족합니다.")
            return
        }

        hero.addHp(Hero.MAX_HP)
        super.useUpMp(SUPER_HEAL_MP_COST)

        println("슈퍼 힐을 시전했습니다. 대상 HP: ${hero.hp}")
    }

    companion object {
        const val MAX_MP = 150
        const val HEAL_MP_COST = 5
        const val HEAL_HP_RECOVERY = 25
        const val SUPER_HEAL_MP_COST = 50
    }
}