package com.ezlevup.my.exercise

import com.ezlevup.my.day05.exercise2.Wand

class Wizard(
    name: String,
    hp: Int,
    var wand: Wand?,
) {
    companion object {
        const val MIN_NAME_LENGTH = 3
        const val MAX_NAME_LENGTH = 10

        const val INITIAL_MP = 100 // MP 초기값
        const val HEAL_HP = 20 // HP 회복값
        const val MP_COST = 10 // MP 소모값
    }

    var mp: Int = Wizard.INITIAL_MP
        set(value) {
            require(value >= 0) { "마법사의 MP는 0 이상이어야 한다." }
            field = value
        }

    var name: String = name
        set(value) {
            require(value.length >= MIN_NAME_LENGTH) { "이름은 최소 ${MIN_NAME_LENGTH}자 이상이어야 합니다." }
            require(value.length <= MAX_NAME_LENGTH) { "이름은 최대 ${MAX_NAME_LENGTH}자를 넘을 수 없습니다." }
            field = value
        }

    var hp: Int = hp
        set(value) {
            field = if (value < 0) 0 else value
        }

    init {
        this.name = name
        this.hp = hp
    }

    fun heal(hero: Hero) {
        if (this.mp < 10) {
            println("마나가 부족합니다.")
        } else {
            this.mp -= Wizard.MP_COST
            hero.addHp(Wizard.HEAL_HP)
            println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
        }
    }
}
