package com.luca.kotlinstudy._05_inheritance

import com.luca.kotlinstudy._02_instance_class.Hero

open class Slime(
    val suffix: String,
    val hp: Int = 10
) {
    var level = 50

    open fun attack(hero: Hero) {
        println("슬라임 $suffix 가 공격했다.")
        println("10의 데미지")
        hero.hp -= 10

    }

    override fun toString(): String {
        return "Slime(name='$suffix', level=$level)"
    }
}