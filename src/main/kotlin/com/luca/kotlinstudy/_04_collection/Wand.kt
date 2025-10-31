package com.luca.kotlinstudy._04_collection

class Wand(
    name: String, // 이름 No null, 3문자 이상
    power: Double, // 마력 0.5 이상 100.0이하
) {
    var name: String = name
        set(value) {
            require(value.length <= 3) { "3글자 이상부터 가능합니다." }
            field = value
        }
    var power: Double = power
        set(value) {
            require(value in 0.5..100.0) { "지팡이의 마력은 0.5 이상 100.0 이하여야 합니다." }
            field = value
        }
}