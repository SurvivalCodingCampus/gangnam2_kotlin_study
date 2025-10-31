package com.ezlevup.my.day05.exercise2

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
            require(value.length >= Wand.MIN_NAME_LENGTH) { "이름은 최소 ${Wand.MIN_NAME_LENGTH}자 이상이어야 합니다." }
            require(value.length <= Wand.MAX_NAME_LENGTH) { "이름은 최대 ${Wand.MAX_NAME_LENGTH}자를 넘을 수 없습니다." }
            field = value
        }

    var power: Double = power
        set(value) {
            require(value in Wand.MIN_MAGIC_POWER..Wand.MAX_MAGIC_POWER) { "지팡이의 마력은 ${Wand.MIN_MAGIC_POWER} 이상 ${Wand.MAX_MAGIC_POWER} 이하여야 한다." }
            field = value
        }

    init {
        this.name = name
        this.power = power
    }
}

