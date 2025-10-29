package com.harry.instance_class

const val MAX_HP = 50
const val MAX_MP = 10

fun main() {
    val cleric = Cleric(
        name = "성직자1",
        hp = 50,
        mp = 5,
    )
    println("before SelfAid()")
    printClericStatus(cleric)
    cleric.selfAid()
    println("After SelfAid()")
    printClericStatus(cleric)
}

class Cleric(
    var name: String,
    var hp: Int,
    val maxHp: Int = MAX_HP,
    var mp: Int,
    val maxMp: Int = MAX_MP,
) {
    fun selfAid() {
        if (this.mp < 5) {
            println("MP가 부족합니다")
        } else if (this.hp == MAX_HP) {
            println("체력이 이미 최대치 입니다")
        } else {
            this.mp -= 5
            this.hp = MAX_HP
            println("체력 회복 완료")
        }
    }
}

fun printClericStatus(cleric: Cleric) {
    println("name : ${cleric.name}\nhp : ${cleric.hp}\nmp: ${cleric.mp}")
}