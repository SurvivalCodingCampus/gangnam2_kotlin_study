package com.ezlevup.my.exercise

class Wand(
    name: String,
    power: Double, // 마력
) {
    companion object {
        const val MIN_NAME_LENGTH = 3
        const val MAX_NAME_LENGTH = 10

        const val MIN_MAGIC_POWER = 0.5
        const val MAX_MAGIC_POWER = 100.0
    }

    var name: String = name
        set(value) {
            require(value.length >= MIN_NAME_LENGTH) { "이름은 최소 ${MIN_NAME_LENGTH}자 이상이어야 합니다." }
            require(value.length <= MAX_NAME_LENGTH) { "이름은 최대 ${MAX_NAME_LENGTH}자를 넘을 수 없습니다." }
            field = value
        }

    var power: Double = power
        set(value) {
            require(value in MIN_MAGIC_POWER..MAX_MAGIC_POWER) { "지팡이의 마력은 ${MIN_MAGIC_POWER} 이상 ${MAX_MAGIC_POWER} 이하여야 한다." }
            field = value
        }

    init {
        this.name = name
        this.power = power
    }
}