package com.neouul.sesac.`03-encapsulation`

class Wand(
    name: String,
    power: Double,
) {
    init {
        checkName(name)
        checkPower(power)
    }

    var name: String = name
        set(value) {
            checkName(value)
            field = value
        }

    var power: Double = power
        set(value) {
            checkPower(value)
            field = value
        }

    private fun checkName(value: String) {
        require(value.length >= MIN_NAME_LENGTH) { "invalid value: 이름은 ${MIN_NAME_LENGTH}자 이상이어야 합니다" }
    }

    private fun checkPower(value: Double) {
        require(value >= MIN_WAND_POWER) { "invalid value: 지팡이의 마력은 ${MIN_WAND_POWER} 이상이어야 합니다" }
        require(value <= MAX_WAND_POWER) { "invalid value: 지팡이의 마력은 ${MAX_WAND_POWER} 이하이어야 합니다" }
    }
}