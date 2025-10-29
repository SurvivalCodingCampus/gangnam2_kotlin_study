package com.sesac.practice.day02

class Cleric(val name: String, var hp: Int = 50, var mp: Int = 10) {
    val maxHp: Int = 50
    val maxMp: Int = 10

    fun selfAid() {
        val selfAidMp = 5

        if (mp < selfAidMp) {
            return
        }

        mp -= selfAidMp
        hp = maxHp
    }
}
