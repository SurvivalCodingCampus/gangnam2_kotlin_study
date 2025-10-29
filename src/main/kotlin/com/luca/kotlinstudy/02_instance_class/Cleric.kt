package com.luca.kotlinstudy.`02_instance_class`

const val MAX_HP = 50
const val MAX_MP = 10


class Cleric(var name: String = "", var hp: Int = MAX_HP, var mp: Int = MAX_MP) {
    fun selfAid() {
        if (mp >= 5 && hp < MAX_HP ) {
            mp -= 5
            hp = MAX_HP
            println("HP: $hp, MP: $mp ")
        }else if(hp == MAX_HP) {
            println("이미 체력이 최대치입니다.")
        } else {
            println("마나가 부족합니다.")
        }
    }
}