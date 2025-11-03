package com.survival.kotlinstudy.`03_encapsulation`

class Wizard(
    name: String,
    hp: Int,
    var wand: Wand?,
) {
    var name: String = name
        set(value) {
            require(value.isNotEmpty()) { "마법사의 이름은 null 일 수 없습니다" }
            require(value.length >= 3) { "마법사의 이름은 3글자 이상이어야 합니다" }
            field = value
        }

    var hp: Int = hp
        set(value) {
            field = if (value < 0) 0 else value
        }

    var mp: Int = 10
        set(value) {
            require(value >= 0) { "마법사의 MP 는 0 이상이어야 합니다" }
            field = value
        }
}