package com.survivalcoding.kotlinstudy.`05_inheritance`

class Wand(
    name: String,
    power: Double,
) {
    init {
        require(name.isNotEmpty()) { "지팡이 이름은 비어 있을 수 없습니다." }
        require(name.length >= 3) { "지팡이 이름은 3글자 이상이어야 합니다." }
        require(power in 0.5..100.0) { "마력은 0.5 이상 100.0 이하여야 합니다." }
    }

    var name: String = name
        set(value) {
            require(value.isNotEmpty()) { "지팡이 이름은 비어있을 수 없습니다." }
            require(value.length >= 3) { "지팡이 이름은 3글자 이상이어야 합니다." }
            field = value
        }

    var power: Double = power
        set(value) {
            require(value in 0.5..100.0) { "지팡이의 마력은 0.5 이상 100.0 이하여야 합니다." }
            field = value
        }
}

// 연습문제 4. Wizard 수정
class Wizard(
    name: String,
    mp: Int = 100,  // 초기값 100
    hp: Int,
    var wand: Wand?,
) {
    // 초기화
    init {
        require(name.isNotEmpty()) { "마법사 이름은 비어 있을 수 없습니다." }
        require(name.length >= 3) { "마법사 이름은 3글자 이상이어야 합니다." }
        require(mp >= 0) { "MP는 0 이상이어야 합니다." }
    }

    var name: String = name
        set(value) {
            require(value.isNotEmpty()) { "마법사 이름은 비어 있을 수 없습니다." }
            require(value.length >= 3) { "마법사 이름은 3글자 이상이어야 합니다." }
            field = value
        }

    var mp: Int = mp
        set(value) {
            require(value >= 0) { "MP는 0 이상이어야 합니다." }
            field = value
        }

    var hp: Int = if (hp < 0) 0 else hp
        set(value) {
            field = if (value < 0) 0 else value
        }

    fun heal(hero: Hero) {
        val discountMp = 10
        val recoveryHp = 20

        if (mp < discountMp) {
            println("마나가 부족합니다")    // mp가 부족하면 "마나가 부족합니다" 출력
        } else {
            hero.hp += recoveryHp   // Unit의 hp를 20 회복시키고
            mp -= discountMp    // 자신의 mp를 10 소모
            println("힐을 시전했습니다. 대상 HP: ${hero.hp}") // 힐 성공시 출력
        }
    }
}