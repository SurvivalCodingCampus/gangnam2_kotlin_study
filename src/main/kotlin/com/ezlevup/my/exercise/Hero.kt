package com.ezlevup.my.exercise

class Hero(
    var name: String,
    var hp: Int,
) {
    val attackPower: Int = 10
    fun attack(slime: Slime) {
        println("attack")
    }

    fun takeDamage(damage: Int) {
        hp -= damage;

        if (hp <= 0) {
            println("die")
            hp = 0
        }
    }
}
