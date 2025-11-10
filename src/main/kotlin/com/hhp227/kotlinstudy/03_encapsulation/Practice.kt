package com.hhp227.kotlinstudy.`03_encapsulation`

import com.hhp227.kotlinstudy.`02_instance_class`.Hero
import java.time.LocalDate
import java.time.format.DateTimeFormatter
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

연습문제2
Person 클래스를 작성하시오.

이름과 태어난 해를 생성자로 받는다 (name, birthYear)
이름과 태어난 해는 한번 정해지면 수정이 불가능하다.
age 프로퍼티를 통해 나이를 제공하지만, 임의로 수정은 불가능하다.
나이 계산은 올해년도에서 birthYear 년도를 뺀 값을 리턴한다
현재 시간과 날짜를 구하는 방법은 검색 해 볼 것
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

class Person(
    val name: String,
    val birthYear: Int
) {
    val age: Int
        get() {
            val formatter = DateTimeFormatter.ofPattern("yyyy")
            return LocalDate.now().format(formatter).toInt() - birthYear
        }
}