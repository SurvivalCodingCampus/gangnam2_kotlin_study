package com.sesac.practice.day05

import org.junit.Test
import kotlin.test.assertEquals

class GreatWizardTest {
    @Test
    fun `GreatWizard를 생성한다`() {
        // given
        val name = "greatWizard"

        // when
        val greatWizard = GreatWizard(name)

        // then
        assertEquals(name, greatWizard.name)
        assertEquals(Hero.MAX_HP, greatWizard.hp)
        assertEquals(GreatWizard.MAX_MP, greatWizard.mp)
    }

    @Test
    fun `GreatWizard가 heal 사용시 mp가 소모된다`() {
        // given
        val greatWizard = GreatWizard("greatWizard")
        val originMp = greatWizard.mp

        val hero = Hero("hero")

        // when
        greatWizard.heal(hero)

        // then
        assertEquals(originMp - GreatWizard.HEAL_COST, greatWizard.mp)
    }

    @Test
    fun `GreatWizard가 heal 사용시 mp가 부족할 경우 대상 hp가 회복되지 않는다`() {
        // given
        val greatWizardMp = GreatWizard.HEAL_COST - 1
        val greatWizard = GreatWizard("greatWizard", greatWizardMp)

        val heroHp = 10
        val hero = Hero("hero", heroHp)

        // when
        greatWizard.heal(hero)

        // then
        assertEquals(heroHp, hero.hp)
    }

    @Test
    fun `GreatWizard가 heal 사용시 대상 hp가 회복된다`() {
        // given
        val greatWizard = GreatWizard("greatWizard")

        val hp = 10
        val hero = Hero("hero", hp)

        // when
        greatWizard.heal(hero)

        // then
        assertEquals(hp + GreatWizard.HEAL_AMOUNT, hero.hp)
    }

    @Test
    fun `GreatWizard가 superHeal 사용시 mp가 소모된다`() {
        // given
        val greatWizard = GreatWizard("greatWizard")
        val originMp = greatWizard.mp

        val hero = Hero("hero")

        // when
        greatWizard.superHeal(hero)

        // then
        assertEquals(originMp - GreatWizard.SUPER_HEAL_COST, greatWizard.mp)
    }

    @Test
    fun `GreatWizard가 superHeal 사용시 대상 hp가 전부 회복된다`() {
        // given
        val greatWizard = GreatWizard("greatWizard")

        val hp = 10
        val hero = Hero("hero", hp)

        // when
        greatWizard.superHeal(hero)

        // then
        assertEquals(Hero.MAX_HP, hero.hp)
    }

    @Test
    fun `GreatWizard가 superHeal 사용시 mp가 부족할 경우 대상 hp가 회복되지 않는다`() {
        // given
        val greatWizardMp = GreatWizard.SUPER_HEAL_COST - 1
        val greatWizard = GreatWizard("greatWizard", greatWizardMp)

        val heroHp = 10
        val hero = Hero("hero", heroHp)

        // when
        greatWizard.superHeal(hero)

        // then
        assertEquals(heroHp, hero.hp)
    }
}
