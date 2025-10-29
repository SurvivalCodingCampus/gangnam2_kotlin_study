package com.ezlevup.my.day03.exercise1

class Cleric(var name: String) {
    val MAX_HP: Int = 50
    val MAX_MP: Int = 10
    val SELF_AID_MP_COST = 5 // 셀프 에이드 마법의 마나 사용량


    var hp: Int = 50
    var mp: Int = 10


    /**
     * MP를 지정된 양만큼 소모합니다.
     *
     * @param amount 소모할 MP의 양
     * @return MP 사용했으면 true를 반환하고, 부족하면 false를 반환합니다.
     */
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


    /**
     * MP를 회복
     */
    fun recoverMp(amount: Int) {
        mp += amount
        if (mp > MAX_MP) {
            mp = MAX_MP
        }
    }


    /**
     * 기도하기
     */
    fun pray(prayDuration: Int) {
        val randomValue = (0..2).random()
        recoverMp(prayDuration + randomValue)
    }
}
