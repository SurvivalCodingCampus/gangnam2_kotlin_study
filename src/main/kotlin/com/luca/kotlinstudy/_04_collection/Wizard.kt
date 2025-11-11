package com.luca.kotlinstudy._04_collection

import com.luca.kotlinstudy._02_instance_class.Hero

const val MIN_HP_MP = 0
const val MIN_NAME_LENGTH = 3

open class Wizard(
    name: String, // No null, 3문자 이상
    hp: Int = DEFAULT_MAX_HP, // HP가 음수가 될 때는 0이 되도록
    mp: Int = DEFAULT_MAX_MP, // MP 0 이상
    var wand: Wand? = null,
    private val healAmount: Int = DEFAULT_HEAL_AMOUNT,
    private val healMpCost: Int = DEFAULT_HEAL_MP_COST,
) {
    var name: String = name
        set(value) {
            require(value.length >= MIN_NAME_LENGTH) { "3글자 이상부터 가능합니다." }
            field = value
        }
    var hp: Int = hp
        set(value) {
            field = if (value < MIN_HP_MP) 0 else value
        }
    var mp: Int = mp
        set(value) {
            require(value >= MIN_HP_MP) { "마법사의 MP는 $MIN_HP_MP 이상이어야 합니다." }
            field = value
        }

    open fun heal(hero: Hero) {
        if (mp < healMpCost) {
            println("마나가 부족합니다.")
            return
        }
        if (hero.hp >= Hero.DEFAULT_MAX_HP) return

        hero.hp = minOf(hero.hp + healAmount, Hero.DEFAULT_MAX_HP)
        mp -= healMpCost
        println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
    }

    init {
        this.name = name
        this.hp = hp
        this.mp = mp
    }

    companion object {
        const val DEFAULT_MAX_HP = 50
        const val DEFAULT_MAX_MP = 100
        const val DEFAULT_HEAL_AMOUNT = 20
        const val DEFAULT_HEAL_MP_COST = 10
    }
}