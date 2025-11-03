package com.sesac.practice.day05

class GreatWizard(
    name: String,
    override var mp: Int = MAX_MP,
) : Wizard(name, mp) {
    override val healCost: Int = HEAL_COST
    override val healAmount: Int = HEAL_AMOUNT
    val superHealCost: Int = SUPER_HEAL_COST

    fun superHeal(hero: Hero) {
        if (mp < superHealCost) {
            println("마나가 부족합니다")
            return
        }

        mp -= superHealCost
        hero.hp = MAX_HP
        println("슈퍼 힐을 시전했습니다. 대상 HP: ${hero.hp}")
    }

    companion object {
        const val MAX_MP = 150
        const val HEAL_COST = 5
        const val HEAL_AMOUNT = 25
        const val SUPER_HEAL_COST = 50
    }
}
