package com.survivalcoding.kotlinstudy.`05_inheritance`.practice

import com.survivalcoding.kotlinstudy.`02_instance_class`.Hero
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class WizardTest {
    @Test
    fun `위자드가 힐을 잘 시전하는지 확인`() {
        val expectedHeroHp = 120     // 히어로의 hp 예상값
        val expectedWizardMp = 90    // 위자드의 mp 예상값
        val wizard = Wizard(DEFAULT_WIZARD_NAME, DEFAULT_WIZARD_HP)
        val hero = Hero(DEFAULT_HERO_NAME, HERO_TEST_HP)

        wizard.heal(hero)

        assertEquals(hero.hp, expectedHeroHp)
        assertEquals(wizard.mp, expectedWizardMp)
    }

    @Test
    fun `마나가 부족할 경우 힐이 작동 안하는지 확인`() {
        val expectedHeroHp = 100     // 히어로의 hp 예상값
        val expectedWizardMp = 5     // 위자드의 mp 예상값
        val wizardTestMp = 5         // 위자드의 테스트용 mp값
        val wizard = Wizard(DEFAULT_WIZARD_NAME, DEFAULT_WIZARD_HP, wizardTestMp)
        val hero = Hero(DEFAULT_HERO_NAME, HERO_TEST_HP)


        wizard.heal(hero)

        assertEquals(hero.hp, expectedHeroHp)
        assertEquals(wizard.mp, expectedWizardMp)
    }

    @Test
    fun `현재체력 + 힐량이 최대체력보다 클때 넘어가지 않는지 확인`() {
        val expectedHeroHp = 150     // 히어로의 hp 예상값
        val expectedWizardMp = 70    // 위자드의 mp 예상값
        val wizard = Wizard(DEFAULT_WIZARD_NAME, DEFAULT_WIZARD_HP)
        val hero = Hero(DEFAULT_HERO_NAME, HERO_TEST_HP)

        wizard.heal(hero)
        wizard.heal(hero)
        wizard.heal(hero)

        assertEquals(hero.hp, expectedHeroHp)
        assertEquals(wizard.mp, expectedWizardMp)
    }

    @Test
    fun `이미 최대체력일 경우 힐을 시전하지 않는지 확인`() {
        val expectedHeroHp = 150     // 히어로의 hp 예상값
        val expectedWizardMp = 70    // 위자드의 mp 예상값
        val wizard = Wizard(DEFAULT_WIZARD_NAME, DEFAULT_WIZARD_HP)
        val hero = Hero(DEFAULT_HERO_NAME, HERO_TEST_HP)

        wizard.heal(hero)
        wizard.heal(hero)
        wizard.heal(hero)
        wizard.heal(hero)

        assertEquals(hero.hp, expectedHeroHp)
        assertEquals(wizard.mp, expectedWizardMp)
    }

    companion object {
        const val DEFAULT_WIZARD_NAME = "간달프"
        const val DEFAULT_WIZARD_HP = 50
        const val DEFAULT_HERO_NAME = "슈퍼맨"
        const val HERO_TEST_HP = 100     // 히어로의 테스트용 hp값
    }
}