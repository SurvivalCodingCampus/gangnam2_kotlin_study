package com.ezlevup.my.exercise

class Hero(
    var name: String,
    var hp: Int,
    var maxHp: Int = Hero.MAX_HP,
) {
    companion object {
        const val MAX_HP: Int = 100
    }

    val attackPower: Int = 10
    fun attack(slime: Slime) {
        println("attack")
    }

    fun takeDamage(damage: Int) {
        if (damage < 0) {
            throw IllegalArgumentException("데미지는 음수가 될 수 없습니다")
        }

        hp -= damage;

        if (hp <= 0) {
            println("die")
            hp = 0
        }
    }
}
