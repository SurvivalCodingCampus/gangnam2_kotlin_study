package com.neouul.sesac.`07-instance-manual`

import kotlin.jvm.javaClass

class Hero(
    var name: String,
    var hp: Int = MAX_HP,
) {
    companion object {
        const val MAX_HP = 80
        const val DAMAGE = 15
    }

    fun attack(slime: Slime) {
        println("$name 이 $slime 을 공격했다")
        slime.hp -= DAMAGE
        println("$DAMAGE 포인트의 데미지를 입혔다")

        println("슬라임의 반격을 받았다")
        hp -= Slime.Companion.DAMAGE
    }

    fun run() {
        println("$name 이 도망쳤다")
    }

    override fun toString(): String {
        return "Hero(name='$name', hp=$hp)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Hero

        if (hp != other.hp) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = hp
        result = 31 * result + name.hashCode()
        return result
    }
}

class Slime(
    var name: String,
    var hp: Int = 10,
){
    companion object {
        const val DAMAGE = 5
    }
}
