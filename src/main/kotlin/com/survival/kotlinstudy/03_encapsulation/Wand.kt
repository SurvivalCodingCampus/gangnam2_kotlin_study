package com.survival.kotlinstudy.`03_encapsulation`

class Wand(
    name: String,
    power: Double,
) {
    var name: String = name
        set(value) {
            require(value.isNotEmpty()) { "지팡이의 이름은 null 일 수 없습니다" }
            require(value.length >= 3) { "지팡이의 이름은 3글자 이상이어야 합니다" }
            field = value
        }

    var power: Double = power
        set(value) {
            require(value >= MIN_POWER) { "지팡이의 마력은 ${MIN_POWER} 이상이어야 한다" }
            require(value <= MAX_POWER) { "지팡이의 마력은 ${MAX_POWER} 이하여야 한다" }
            field = value
        }


    companion object {
        const val MIN_POWER = 0.5
        const val MAX_POWER = 100.0
    }


}