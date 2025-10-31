package com.neouul.sesac.`04-encapsulation`

class Wand(
    name: String,
    power: Double,
) {
    var name: String = name
        set(value) {
            require(value.length >= MIN_NAME_LENGTH) { "invalid value: 이름은 ${MIN_NAME_LENGTH}자 이상이어야 합니다" }
            field = value
        }

    var power: Double = power
        set(value) {
            require(value >= MIN_WAND_POWER) { "invalid value: 지팡이의 마력은 ${MIN_WAND_POWER} 이상이어야 합니다" }
            require(value <= MAX_WAND_POWER) { "invalid value: 지팡이의 마력은 ${MAX_WAND_POWER} 이하이어야 합니다" }
            field = value
        }
}