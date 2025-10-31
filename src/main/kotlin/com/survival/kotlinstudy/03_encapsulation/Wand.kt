package com.survival.kotlinstudy.`03_encapsulation`

class Wand(
    name: String,
    var power: Double,
) {
    var name: String = name
        set(value) {
            require(value.isNotEmpty()) { "지팡이의 이름은 null 일 수 없습니다" }
            require(value.length >= 3) { "지팡이의 이름은 3글자 이상이어야 합니다" }
            field = value
        }

}