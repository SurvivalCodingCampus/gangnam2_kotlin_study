package com.ezlevup.my.exercise

class Hero(
    var name: String,
    hp: Int,
    maxHp: Int = Hero.MAX_HP,
) {
    companion object {
        const val MAX_HP: Int = 100
    }

    var hp: Int = hp
        private set // setter를 private으로 제한

    var maxHp: Int = maxHp
        private set // setter를 private으로 제한

    val attackPower: Int = 10
    fun attack(slime: Slime) {
        println("attack")
    }

    fun takeDamage(damage: Int) {
        println("$damage 의 데미지를 받았습니다.")

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
