package com.survivaalcoding.kotlinstudy.`03_encapsulation`.example

class Wand(val name: String, var power: Double) {
    init {
        if (isBlank()) {
            throw IllegalArgumentException("이름은 빈 문자 혹은 공백일 수 없습니다.")
        }

        if (this.name.length < NAME_LENGTH_RULE) {
            throw IllegalArgumentException("이름은 ${NAME_LENGTH_RULE}자 이상이어야 합니다.")
        }

        if (this.power !in MIN_POWER..MAX_POWER) {
            throw IllegalArgumentException("마력은 $MIN_POWER ~ $MAX_POWER 범위까지만 지정 가능합니다.")
        }
    }

    private fun isBlank(): Boolean = this.name.isEmpty() || this.name.isBlank()

    companion object {
        const val NAME_LENGTH_RULE = 3
        const val MIN_POWER = 0.5
        const val MAX_POWER = 100.0
    }
}