package com.ezlevup.my.day03.exercise1

import kotlin.math.min


class Cleric(
    var name: String,
    var hp: Int = ClericConfig.MAX_HP,
    var mp: Int = ClericConfig.MAX_MP,
) {

    init {
        require(name.isNotEmpty()) {
            "이름이 없으면 작명소에서 만들어서 오세요."
        }

        require(name.length in ClericConfig.MIN_NAME_LENGTH..ClericConfig.MAX_NAME_LENGTH) {
            "이름은 ${ClericConfig.MIN_NAME_LENGTH}자 이상 ${ClericConfig.MAX_NAME_LENGTH}자 이하로 부탁해요."
        }
    }

    /**
     * MP를 지정된 양만큼 소모합니다.
     *
     * @param amount 소모할 MP의 양
     * @return MP 사용했으면 true를 반환하고, 부족하면 false를 반환합니다.
     */
    fun useMp(amount: Int): Boolean {
        if (amount < 0) {
            println("MP 사용량은 0 이상이어야 합니다: $amount")
            return false
        }

        return if (mp >= amount) {
            mp -= amount
            true
        } else {
            false
        }
    }


    fun selfAid() {
        if (useMp(ClericConfig.SELF_AID_MP_COST)) {
            hp = ClericConfig.MAX_HP
            println("회복 성공 hp: $hp, mp: $mp")
        } else {
            println("회복 실패 hp: $hp, mp: $mp / 필요한 MP는 ${ClericConfig.SELF_AID_MP_COST}")
        }
    }


    /**
     * MP를 회복
     */
    fun recoverMp(amount: Int) {
        if (amount < 0) {
            println("회복량은 0 이상이어야 합니다: $amount")
            return
        }

        mp = min(mp + amount, ClericConfig.MAX_MP)
    }


    fun prayBonus(): Int = ClericConfig.bonusCalculator()

    /**
     * 기도하기
     */
    fun pray(prayDuration: Int): Int {
        if (prayDuration <= 0) {
            println("기도 시간은 1 이상이어야 합니다!: $prayDuration")
            return 0
        }

        val bonusMp = prayBonus() + prayDuration
        recoverMp(bonusMp)

        return bonusMp
    }
}
