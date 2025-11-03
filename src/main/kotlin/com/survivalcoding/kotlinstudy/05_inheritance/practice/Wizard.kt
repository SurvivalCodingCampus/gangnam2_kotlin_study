package com.survivalcoding.kotlinstudy.`05_inheritance`.practice

import com.survivalcoding.kotlinstudy.`02_instance_class`.Hero
import com.survivalcoding.kotlinstudy.`03_encapsulation`.practice.Wand

/*
Wizard 수정

속성:
-   mp: Int (초기값 100)
메서드:
-   heal(hero: Hero): Unit의 hp를 20 회복시키고 자신의 mp를 10 소모
-   mp가 부족하면 "마나가 부족합니다" 출력
-   힐을 성공하면 "힐을 시전했습니다. 대상 HP: ${hero.hp}" 출력
*/

open class Wizard(
    name: String,
    hp: Int,
    mp: Int = DEFAULT_MP,
    wand: Wand? = null,
) {
    var wand: Wand? = wand

    // 이름이 3자 미만인 상황
    var name: String = name
        set(value) {
            if (value.length < 3) {
                throw IllegalArgumentException("이름이 3자 이상이어야 합니다.")
            }

            if (value.length > 8) {
                throw IllegalArgumentException("이름이 8자 이하이어야 합니다.")
            }

            if (value.contains(" ")) {
                throw IllegalArgumentException("이름에 공백이 포함되어 있습니다.")
            }

            if (value.contains(Regex("[^A-Za-z0-9가-힣]"))) {
                throw IllegalArgumentException("이름에 특수문자가 포함되어 있습니다.")
            }

            field = value
        }

    // mp가 음수가 되는 상황
    var mp: Int = mp
        set(value) {
            if (value < 0) {
                throw IllegalArgumentException("MP는 0 이상이어야 합니다.")
            }

            if (value > 1000) {
                throw IllegalArgumentException("MP는 1000 이하이어야 합니다.")
            }

            field = value
        }

    // hp가 음수가 되는 상황
    var hp: Int = hp
        set(value) {
            field = if (value < 0) 0 else value
        }

    fun canHeal(hero: Hero, cost: Int): Boolean {
        // 마나가 부족할 경우
        if (mp < cost) {
            println("마나가 부족합니다")
            return false
        }

        // hp가 이미 최대일 경우
        if (hero.hp == hero.maxHp) {
            println("이미 최대체력입니다")
            return false
        }
        return true
    }

    open fun heal(hero: Hero) {
        val healAmount = 20
        val healCost = 10

        if (!canHeal(hero, healCost)) return

        // 힐량이 최대체력보다 많을 경우
        if (hero.hp + healAmount > hero.maxHp) hero.hp = hero.maxHp else hero.hp += healAmount

        mp -= healCost
        println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
    }

    companion object {
        const val DEFAULT_MP = 100
    }
}