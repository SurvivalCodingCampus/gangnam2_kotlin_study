package com.survivaalcoding.kotlinstudy.`03_encapsulation`

class Wizard(
    val name: String,
    var hp: Int,
    var mp: Int,
    var wand: Wand? = null
) {
    init {
        if (isBlank()) {
            throw IllegalArgumentException("이름은 빈 문자 혹은 공백일 수 없습니다.")
        }

        if (this.name.length < NAME_LENGTH_RULE) {
            throw IllegalArgumentException("이름은 ${NAME_LENGTH_RULE}자 이상이어야 합니다.")
        }

        if (hp < MIN_HP) {
            hp = MIN_HP
        }

        if (mp < MIN_MP) {
            throw IllegalArgumentException("MP는 최소 $MIN_MP 이상이어야 합니다.")
        }
    }

    private fun isBlank(): Boolean = this.name.isEmpty() || this.name.isBlank()

    companion object {
        const val NAME_LENGTH_RULE = 3
        const val MIN_HP = 0
        const val MIN_MP = 0
    }
}