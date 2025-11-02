package com.hhp227.kotlinstudy.`03_encapsulation`

import kotlin.math.max

/*
연습문제1
다음 2개의 클래스 “Wizard (마법사)”, “Wand (지팡이)” 를 작성하시오. 마법사는 지팡이를 들 수 있습니다.

연습문제1-2
작성한 Wand 클래스와 Wizard 클래스에 대해, 아래의 규칙에 따라 타당성 검사를 추가하시오.
부정한 값이 설정 될 경우에는 “IllegalArgumentException(“메세지")” 를 작성하여 프로그램을 중단 시킵니다.
마법사나 지팡이의 이름은 null 일 수 없고, 반드시 3문자 이상이어야 한다
지팡이의 마력은 0.5 이상 100.0 이하여야 한다.
마법사의 MP는 0 이상이어야 한다.
HP가 음수가 되는 상황에서는 대신 0을 설정 되도록 한다.
 */
class Wizard(
    _name: String,
    _hp: Int,
    var wand: Wand
) {
    var mp: Int = 0
        set(value) {
            if (value > -1) field = value
            else throw IllegalArgumentException("MP는 0 이상이어야 합니다.")
        }

    var name = _name
        set(value) {
            validName(value)
            field = value
        }

    var hp = _hp
        set(value) {
            field = max(0, value)
        }

    fun validName(name: String) {
        require(name.length > 2) { "이름은 3문자 이상이어야 합니다." }
    }

    init {
        require(_name.length > 2) { "이름은 3문자 이상이어야 합니다" }
    }
}

class Wand(
    _name: String, // 이름
    _power: Double // 마력
) {
    var name = _name
        set(value) {
            validName(value)
            field = value
        }

    var power = _power
        set(value) {
            require(value in 0.5..100.0) { "지팡이의 마력은 0.5이상 100.0이하여야 합니다." }
            field = value
        }

    fun validName(name: String) {
        require(name.length > 2) { "이름은 3문자 이상이어야 합니다." }
    }

    init {
        require(_name.length > 2) { "이름은 3문자 이상이어야 합니다" }
        require(power in 0.5..100.0) { "지팡이의 마력은 0.5이상 100.0이하여야 합니다" }
    }
}