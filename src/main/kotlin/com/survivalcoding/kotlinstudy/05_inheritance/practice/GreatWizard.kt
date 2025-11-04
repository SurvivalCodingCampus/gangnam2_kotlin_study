package com.survivalcoding.kotlinstudy.`05_inheritance`.practice

import com.survivalcoding.kotlinstudy.`02_instance_class`.Hero

class GreatWizard(
    name: String,
    hp: Int,
) : Wizard(name, hp, DEFAULT_GREAT_WIZARD_MP) {
    // heal() 재정의
    override fun heal(hero: Hero) {
        val greatHealAmount = 25    // Great Wizard의 힐량
        val greatHealCost = 5       // Great Wizard의 힐코스트

        if (!canHeal(hero, greatHealCost)) return

        // 힐량이 최대체력보다 많을 경우
        if (hero.hp + greatHealAmount > hero.maxHp) hero.hp = hero.maxHp else hero.hp += greatHealAmount

        mp -= greatHealCost
    }

    fun superHeal(hero: Hero) {
        val superHealCost = 50 // superHeal의 코스트

        if (mp < superHealCost) {
            println("마나가 부족합니다")
            return
        }

        hero.hp = hero.maxHp
        mp -= superHealCost
        println("슈퍼 힐을 시전했습니다. 대상 HP:${hero.hp}")
    }

    companion object {
        const val DEFAULT_GREAT_WIZARD_MP = 150 // Great Wizard의 기본 mp
    }
}