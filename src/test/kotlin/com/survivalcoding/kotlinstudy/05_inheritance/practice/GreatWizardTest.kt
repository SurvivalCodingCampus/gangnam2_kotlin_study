package com.survivalcoding.kotlinstudy.`05_inheritance`.practice

import com.survivalcoding.kotlinstudy.`02_instance_class`.Hero
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class GreatWizardTest {
    @Test
    fun `대마법사가 잘 생성되는지 확인`() {
        val greatWizard = GreatWizard(DEFAULT_GREAT_WIZARD_NAME, DEFAULT_GREAT_WIZARD_HP)

        assertEquals(greatWizard.name, DEFAULT_GREAT_WIZARD_NAME)
    }

    @Test
    fun `힐량이 대마법사에서 늘어났는지 확인`() {
        val expectedHeroHp = 125     // 히어로의 hp 예상값
        val expectedGreatWizardMp = 145 // 대마법사의 mp 예상값
        val greatWizard = GreatWizard(DEFAULT_GREAT_WIZARD_NAME, DEFAULT_GREAT_WIZARD_HP)
        val hero = Hero(DEFAULT_HERO_NAME, HERO_TEST_HP)

        greatWizard.heal(hero)

        assertEquals(hero.hp, expectedHeroHp)
        assertEquals(greatWizard.mp, expectedGreatWizardMp)
    }

    @Test
    fun `이미 최대체력인데 힐을 사용했을 경우 확인`() {
        val expectedHeroHp = 150     // 히어로의 hp 예상값
        val expectedGreatWizardMp = 140 // 대마법사의 mp 예상값
        val greatWizard = GreatWizard(DEFAULT_GREAT_WIZARD_NAME, DEFAULT_GREAT_WIZARD_HP)
        val hero = Hero(DEFAULT_HERO_NAME, HERO_TEST_HP)

        greatWizard.heal(hero)
        greatWizard.heal(hero)
        greatWizard.heal(hero)

        assertEquals(hero.hp, expectedHeroHp)
        assertEquals(greatWizard.mp, expectedGreatWizardMp)
    }

    @Test
    fun `슈퍼힐이 잘 작동하나 확인`() {
        val expectedHeroHp = 150     // 히어로의 hp 예상값
        val expectedGreatWizardMp = 100 // 대마법사의 mp 예상값
        val greatWizard = GreatWizard(DEFAULT_GREAT_WIZARD_NAME, DEFAULT_GREAT_WIZARD_HP)
        val hero = Hero(DEFAULT_HERO_NAME, HERO_TEST_HP)

        greatWizard.superHeal(hero)

        assertEquals(hero.hp, expectedHeroHp)
        assertEquals(greatWizard.mp, expectedGreatWizardMp)
    }

    companion object {
        const val DEFAULT_GREAT_WIZARD_NAME = "위대한간달프"
        const val DEFAULT_GREAT_WIZARD_HP = 150
        const val DEFAULT_HERO_NAME = "슈퍼맨"
        const val HERO_TEST_HP = 100     // 히어로의 테스트용 hp값
    }
}