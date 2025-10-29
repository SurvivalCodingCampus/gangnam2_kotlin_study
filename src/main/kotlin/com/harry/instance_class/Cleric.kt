package com.harry.instance_class

import kotlin.random.Random

const val MAX_HP = 50
const val MAX_MP = 10

fun main() {
    val prayTime = 1
    val cleric = Cleric(
        name = "성직자1",
        hp = 50,
        mp = 5,
    )
    println("before selfAid")
    printClericStatus(cleric)
    cleric.selfAid()
    println("After selfAid")
    printClericStatus(cleric)

    println("before pray")
    println("${cleric.mp}")
    println("${prayTime}동안 회복한 MP 양 : ${cleric.pray(prayTime)}")
    println("After pray")
    println("${cleric.mp}")
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

    fun pray(prayTime: Int) : Int {
        val healResult = prayTime + Random.nextInt(2)
        if (this.mp+healResult > MAX_MP) {
            println("MP 회복이 불가능 합니다.")
            return 0
        } else {
            this.mp+=healResult
            return healResult
        }
    }
}

fun printClericStatus(cleric: Cleric) {
    println("name : ${cleric.name}\nhp : ${cleric.hp}\nmp: ${cleric.mp}")
}