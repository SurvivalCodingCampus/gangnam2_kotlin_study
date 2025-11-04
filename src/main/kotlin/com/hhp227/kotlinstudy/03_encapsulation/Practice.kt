package com.hhp227.kotlinstudy.`03_encapsulation`

import com.hhp227.kotlinstudy.`02_instance_class`.Hero
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

/*
연습문제4 - Wizard 수정
속성:
mp: Int (초기값 100)
메서드:
heal(hero: Hero): Unit의 hp를 20 회복시키고 자신의 mp를 10 소모
mp가 부족하면 "마나가 부족합니다" 출력
힐을 성공하면 "힐을 시전했습니다. 대상 HP: ${hero.hp}" 출력
 */

open class Wizard(
    name: String,
    hp: Int,
    var wand: Wand
) {
    open var mp: Int = 100
        set(value) {
            if (value > -1) field = value
            else throw IllegalArgumentException("MP는 0 이상이어야 합니다.")
        }

    var name = name
        set(value) {
            validName(value)
            field = value
        }

    var hp = hp
        set(value) {
            field = max(0, value)
        }

    fun validName(name: String) {
        require(name.length > 2) { "이름은 3문자 이상이어야 합니다." }
    }

    open fun heal(hero: Hero) {
        if (mp < 10) {
            println("마나가 부족합니다")
            return
        }
        hero.hp += 20
        mp -= 10
        println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
    }

    init {
        require(name.length > 2) { "이름은 3문자 이상이어야 합니다" }
    }
}

class Wand(
    name: String, // 이름
    power: Double // 마력
) {
    var name = name
        set(value) {
            validName(value)
            field = value
        }

    var power = power
        set(value) {
            require(value in 0.5..100.0) { "지팡이의 마력은 0.5이상 100.0이하여야 합니다." }
            field = value
        }

    fun validName(name: String) {
        require(name.length > 2) { "이름은 3문자 이상이어야 합니다." }
    }

    init {
        require(name.length > 2) { "이름은 3문자 이상이어야 합니다" }
        require(this@Wand.power in 0.5..100.0) { "지팡이의 마력은 0.5이상 100.0이하여야 합니다" }
    }
}