package com.neouul.sesac.`05-inheritance`

class Wand(
    name: String,
    power: Double,
) {
    companion object{
        const val MIN_NAME_LENGTH = 3
        const val MIN_POWER = 0.5
        const val MAX_POWER = 100.0
    }

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
        require(value >= MIN_POWER) { "invalid value: 지팡이의 마력은 ${MIN_POWER} 이상이어야 합니다" }
        require(value <= MAX_POWER) { "invalid value: 지팡이의 마력은 ${MAX_POWER} 이하이어야 합니다" }
    }
}