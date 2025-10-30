package com.ezlevup.my.day03.exercise1

class ClericConfig() {
    companion object {
        const val MAX_HP: Int = 50
        const val MAX_MP: Int = 10
        const val SELF_AID_MP_COST = 5 // 셀프 에이드 마법의 마나 사용량

        private const val MIN_BONUS = 0
        private const val MAX_BONUS = 2

        fun bonusCalculator(): Int = (MIN_BONUS..MAX_BONUS).random()

        const val MIN_NAME_LENGTH = 2
        const val MAX_NAME_LENGTH = 10
    }
}
