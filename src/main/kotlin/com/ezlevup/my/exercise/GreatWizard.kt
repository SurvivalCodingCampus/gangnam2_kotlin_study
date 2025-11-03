package com.ezlevup.my.exercise

class GreatWizard(
    name: String,
    hp: Int,
    override var wand: Wand?,
) : Wizard(name, hp, wand) {
    companion object {
        const val INITIAL_MP = 150 // MP 초기값
        const val HEAL_HP = 25 // HP 회복값
        const val HEAL_MP_COST = 5 // heal MP 소모값
        const val SUPER_HEAL_MP_COST = 5 // super heal MP 소모값
    }

    init {
        mp = GreatWizard.INITIAL_MP
    }

    override fun heal(hero: Hero) {
        if (this.mp < GreatWizard.HEAL_MP_COST) {
            println("마나가 부족합니다.")
        } else {
            this.mp -= GreatWizard.HEAL_MP_COST
            hero.addHp(GreatWizard.HEAL_HP)
            println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
        }
    }

    fun superHeal(hero: Hero) {
        if (this.mp < GreatWizard.SUPER_HEAL_MP_COST) {
            println("마나가 부족합니다.")
        } else {
            this.mp -= GreatWizard.SUPER_HEAL_MP_COST
            hero.addHp(Hero.MAX_HP)
            println("슈퍼 힐을 시전했습니다. 대상 HP: ${hero.hp}")
        }
    }
}
