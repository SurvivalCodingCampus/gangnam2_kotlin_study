package com.survival.kotlinstudy.`02_instance_class`

class Cleric(var name: String, var hp: Int, var mp: Int) {
    val maxHp: Int = 50
    val maxMp: Int = 50
    fun selfAid() {
        if (mp < 5) return
        else {
            mp -= 5
            hp = maxHp
        }
    }
}