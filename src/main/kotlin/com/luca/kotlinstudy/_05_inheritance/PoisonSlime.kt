package com.luca.kotlinstudy._05_inheritance

import com.luca.kotlinstudy._02_instance_class.HERO_MAX_HP
import com.luca.kotlinstudy._02_instance_class.Hero

const val POISON_COUNT = 5

class PoisonSlime(suffix: String) : Slime(suffix) {
    var poisonCount = POISON_COUNT
        set(value) {
            field = if (value < 0) 0 else value
        }

    override fun attack(hero: Hero) {
        super.attack(hero)
        if (poisonCount <= 0) return // 독 다 떨어지면 추가공격 X

        println("추가로 독 포자를 살포했다!")
        val damage = HERO_MAX_HP / 5
        hero.hp -= damage
        println("$damage 포인트의 데미지!")
        poisonCount--
    }
}