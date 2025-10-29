package com.harry.instance_class

const val MAX_HP = 50
const val MAX_MP = 10

fun main() {

}

class Cleric(
    val name: String,
    var hp: Int,
    val maxHp: Int = MAX_HP,
    val mp: Int,
    val maxMp: Int = MAX_MP,
) {
    fun attach() {
        hp-=10
    }
}