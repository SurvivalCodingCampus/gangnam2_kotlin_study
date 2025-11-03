package _251103_kotlin_oop.inheritance

import _251030_kotlin_oop.MAX_HP
import _251031_kotlin_oop.encapsulation.Wand

const val GREATWIZARD_MINIMUM_MP = 150 //great마법사 최소 mp
const val GREATWIZARD_HEAL_REQUIRED_MP = 5
const val GREATWIZARD_HEAL_TREAT_HP = 25
const val GREATWIZARD_SUPERHEAL_REQUIRED_MP = 50

class GreatWizard(
    name: String,
    hp: Int,
    wand: Wand?
) : Wizard(name, hp, wand) {
    override var mp: Int = GREATWIZARD_MINIMUM_MP
    override fun heal(hero: Hero) {
        if (mp < GREATWIZARD_HEAL_REQUIRED_MP) {//마나부족
            println("마나가 부족합니다.")
        } else {//마나충분
            if (hero.hp + GREATWIZARD_HEAL_TREAT_HP > MAX_HP) {
                hero.hp = MAX_HP
            } else {
                hero.hp += GREATWIZARD_HEAL_TREAT_HP
            }
            mp -= GREATWIZARD_HEAL_REQUIRED_MP
            println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
        }
    }

    fun superHeal(hero: Hero) {
        if (mp < GREATWIZARD_SUPERHEAL_REQUIRED_MP) {
            println("마나가 부족합니다.")
        } else {
            hero.hp = MAX_HP
            println("슈퍼힐을 시전했습니다. 대상 HP: ${hero.hp}")
            mp -= GREATWIZARD_SUPERHEAL_REQUIRED_MP
        }
    }

}