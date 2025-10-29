package com.ezlevup.my.day03.exercise1

class Cleric(var name: String) {
    val MAX_HP: Int = 50
    val MAX_MP: Int = 10
    val SELF_AID_MP_COST = 5 // 셀프 에이드 마법의 마나 사용량

    var hp: Int = 50
    var mp: Int = 10

    fun useMp(amount: Int): Boolean {
        return if (mp >= amount) {
            mp -= amount
            true
        } else {
            false
        }
    }

    fun selfAid() {
        if (useMp(SELF_AID_MP_COST)) {
            hp = MAX_HP
            println("회복 성공 hp: $hp, mp: $mp")
        } else {
            println("회복 실패 hp: $hp, mp: $mp / 필요한 MP는 $SELF_AID_MP_COST")
        }
    }
}
