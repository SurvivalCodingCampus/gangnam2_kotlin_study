package com.sesac.practice.day04

class Wand(
    val name: String,
    val power: Double,
) {
    init {
        require(name.length >= NAME_SIZE) { "이름은 ${NAME_SIZE}자 이상이어야 합니다." }
        require(power in MIN_POWER..MAX_POWER) { "마력은 $MIN_POWER 이상 $MAX_POWER 이하여야 합니다." }
    }

    companion object {
        const val NAME_SIZE = 3
        const val MIN_POWER = 0.5
        const val MAX_POWER = 100.0
    }
}
