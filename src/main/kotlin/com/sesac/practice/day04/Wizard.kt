package com.sesac.practice.day04

import kotlin.math.max

class Wizard(
    val name: String,
    hp: Int,
    mp: Int,
    val wand: Wand?,
) {
    var hp = hp
        set(value) {
            field = max(value, MIN_HP)
        }

    var mp = mp
        set(value) {
            require(value >= MIN_MP) { "MP는 $MIN_MP 이상이어야 합니다." }

            field = value
        }

    init {
        require(name.length >= NAME_SIZE) { "이름은 ${NAME_SIZE}자 이상이어야 합니다." }
        require(mp >= MIN_MP) { "MP는 $MIN_MP 이상이어야 합니다." }

        if (hp < MIN_HP) {
            this.hp = MIN_HP
        }
    }

    companion object {
        const val NAME_SIZE = 3
        const val MIN_HP = 0
        const val MIN_MP = 0
    }
}
