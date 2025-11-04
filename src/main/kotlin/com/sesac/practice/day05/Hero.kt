package com.sesac.practice.day05

import kotlin.math.max

open class Hero(
    val name: String,
    hp: Int = MAX_HP,
) {
    var hp = hp
        set(value) {
            field = max(value, MIN_HP)
        }

    init {
        require(name.length >= NAME_SIZE) { "이름은 ${NAME_SIZE}자 이상이어야 합니다." }

        this.hp = hp
    }

    companion object {
        const val NAME_SIZE = 3
        const val MIN_HP = 0
        const val MAX_HP = 50
    }
}
