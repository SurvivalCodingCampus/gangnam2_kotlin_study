package com.survivaalcoding.kotlinstudy.`05_inheritance`

import kotlin.math.min

open class Hero(var name: String, var hp: Int = MAX_HP) {
    init {
        println("Hero init")
    }

    fun attack() = println("${name}은 공격중")
    open fun run() = println("$name 은 뛰는중")
    fun sit(sec: Int) = println("$name 은 ${sec}초 동안 앉아 있다")
    fun slip() = println("$name 은 넘어졌다")
    fun sleep() {
        hp = 100
        println("${name}은 잠을 자고 회복했다!")
    }

    fun isAvailableAttack() = hp > MIN_HP

    fun addHp(hpRecovery: Int) {
        if (hpRecovery <= 0) {
            throw IllegalArgumentException("회복량은 음수일 수 없습니다.")
        }

        hp = min(MAX_HP, hp + hpRecovery)
    }

    companion object {
        const val MIN_HP = 0
        const val MAX_HP = 100
    }
}
