package com.survivalcoding.kotlinstudy.`05_inheritance`

import kotlin.test.Test
import kotlin.test.assertEquals

class WizardTest {

    companion object {
        // Hero
        private const val HERO_NAME = "용사"
        private const val HERO_INITIAL_HP = 50
        private const val NEGATIVE_HP = -10

        // Wizard
        private const val WIZARD_NAME = "마법사"
        private const val WIZARD_MP_FULL = 100
        private const val WIZARD_MP_LOW = 5
        private const val WIZARD_HP = 80
        private const val WIZARD_HP_LOW = 70
        private const val WIZARD_HP_FULL = 90

        // Wand
        private const val WAND_NAME = "지팡이"
        private const val WAND_POWER = 50.0

        // 마나
        private const val HP_RECOVERY = 20
        private const val MP_COST = 10
    }

    @Test
    fun `힐 성공 - 용사 HP 20 회복, 마법사 MP 10 소모`() {
        // given
        val hero = Hero(HERO_NAME, HERO_INITIAL_HP)
        val wand = Wand(WAND_NAME, WAND_POWER)
        val wizard = Wizard(WIZARD_NAME, mp = WIZARD_MP_FULL, hp = WIZARD_HP, wand = wand)

        // when
        wizard.heal(hero)

        // then
        assertEquals(HERO_INITIAL_HP + HP_RECOVERY, hero.hp) // 회복 성공
        assertEquals(WIZARD_MP_FULL - MP_COST, wizard.mp)     // MP 소모 확인
    }

    @Test
    fun `마나 부족 - 힐 실패`() {
        // given
        val hero = Hero(HERO_NAME, HERO_INITIAL_HP)
        val wand = Wand(WAND_NAME, WAND_POWER)
        val wizard = Wizard(WIZARD_NAME, mp = WIZARD_MP_LOW, hp = WIZARD_HP_LOW, wand = wand)

        // when
        wizard.heal(hero)

        // then
        assertEquals(HERO_INITIAL_HP, hero.hp)  // 회복되지 않음
        assertEquals(WIZARD_MP_LOW, wizard.mp)  // MP 소모 없음
    }

    @Test
    fun `회복 후 MP가 0 - 다음 힐 실패`() {
        // given
        val hero = Hero(HERO_NAME, HERO_INITIAL_HP)
        val wand = Wand(WAND_NAME, WAND_POWER)
        val wizard = Wizard(WIZARD_NAME, mp = MP_COST, hp = WIZARD_HP_FULL, wand = wand)

        // when
        wizard.heal(hero)  // 첫 힐 성공
        wizard.heal(hero)  // 두 번째 힐 시도 (MP 부족)

        // then
        assertEquals(HERO_INITIAL_HP + HP_RECOVERY, hero.hp) // 첫 힐만 성공
        assertEquals(0, wizard.mp)                           // MP 전부 소모됨
    }
}
