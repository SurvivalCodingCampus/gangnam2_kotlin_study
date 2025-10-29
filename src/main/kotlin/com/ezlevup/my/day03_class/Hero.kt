package com.ezlevup.my.day03_class

class Hero(var name: String, var hp: Int) {
    val attackPower: Int = 10
    fun attack() {
        println("attack")
        hp -= attackPower
        if (hp < 0) {
            hp = 0
        }
    }
}

fun main() {
    val hero = Hero(name = "lee", hp = 100)
    hero.attack()
}

