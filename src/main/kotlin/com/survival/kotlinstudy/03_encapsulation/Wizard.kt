package com.survival.kotlinstudy.`03_encapsulation`

import com.survival.kotlinstudy.`02_instance_class`.Hero

class Wizard(
    name: String,
    hp: Int,
    var wand: Wand?,
) {
    var name: String = name
        set(value) {
            require(value.isNotEmpty()) { "마법사의 이름은 null 일 수 없습니다" }
            require(value.length >= 3) { "마법사의 이름은 3글자 이상이어야 합니다" }
            field = value
        }

    var hp: Int = hp
        set(value) {
            field = if (value < 0) 0 else value
        }

    var mp: Int = INIT_MP
        set(value) {
            require(value >= 0) { "마법사의 MP 는 0 이상이어야 합니다" }
            field = value
        }

    fun heal(hero: Hero) {
        if (mp < HEAL_COST) {
            println("마나가 부족합니다.")
            return
        }
        hero.hp += HEAL_HP
        mp -= HEAL_COST
        println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
    }


    companion object {
        const val INIT_MP = 100
        const val HEAL_COST = 10
        const val HEAL_HP = 20
    }
}