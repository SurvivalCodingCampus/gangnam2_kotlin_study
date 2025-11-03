package com.survivalcoding.kotlinstudy.`05_inheritance`

import kotlin.test.Test
import kotlin.test.assertEquals

class GreatWizardTest {

    companion object {
        // Hero
        private const val HERO_NAME = "용사"
        private const val HERO_INITIAL_HP = 50
        private const val HERO_MAX_HP = 100

        // Wizard
        private const val WIZARD_NAME = "대마법사"
        private const val WIZARD_MP_FULL = 150
        private const val WIZARD_MP_LOW = 4

        // Wand
        private const val WAND_NAME = "지팡이"
        private const val WAND_POWER = 80.0

        // 마나
        private const val HP_RECOVERY = 25
        private const val MP_COST = 5
        private const val SUPER_HEAL_COST = 50
    }

    @Test
    fun `힐 성공 - 용사 HP 25 회복, 마법사 MP 5 소모`() {
        // given
        val hero = Hero(HERO_NAME, HERO_INITIAL_HP)
        val wand = Wand(WAND_NAME, WAND_POWER)
        val wizard = GreatWizard(WIZARD_NAME, hp = 90, mp = WIZARD_MP_FULL, wand = wand)

        // when
        wizard.heal(hero)

        // then
        assertEquals(HERO_INITIAL_HP + HP_RECOVERY, hero.hp) // HP 25 회복
        assertEquals(WIZARD_MP_FULL - MP_COST, wizard.mp)     // MP 5 소모
    }

    @Test
    fun `힐 실패 - MP가 부족한 경우`() {
        // given
        val hero = Hero(HERO_NAME, HERO_INITIAL_HP)
        val wand = Wand(WAND_NAME, WAND_POWER)
        val wizard = GreatWizard(WIZARD_NAME, hp = 80, mp = WIZARD_MP_LOW, wand = wand)

        // when
        wizard.heal(hero)

        // then
        assertEquals(HERO_INITIAL_HP, hero.hp) // 회복 안 됨
        assertEquals(WIZARD_MP_LOW, wizard.mp) // MP 변화 없음
    }

    @Test
    fun `슈퍼 힐 성공 - 용사 HP 완전 회복, 마법사 MP 50 소모`() {
        // given
        val hero = Hero(HERO_NAME, hp = 50, maxHp = 100)
        val wand = Wand(WAND_NAME, WAND_POWER)
        val wizard = GreatWizard(WIZARD_NAME, hp = 100, mp = WIZARD_MP_FULL, wand = wand)

        // when
        wizard.superHeal(hero)

        // then
        assertEquals(HERO_MAX_HP, hero.hp) // 완전 회복
        assertEquals(WIZARD_MP_FULL - SUPER_HEAL_COST, wizard.mp) // MP 50 소모
    }

    @Test
    fun `슈퍼 힐 실패 - MP가 부족한 경우`() {
        // given
        val hero = Hero(HERO_NAME, HERO_INITIAL_HP)
        val wand = Wand(WAND_NAME, WAND_POWER)
        val wizard = GreatWizard(WIZARD_NAME, hp = 100, mp = 10, wand = wand)

        // when
        wizard.superHeal(hero)

        // then
        assertEquals(HERO_INITIAL_HP, hero.hp) // 회복되지 않음
        assertEquals(10, wizard.mp)            // MP 소모 없음
    }
}
