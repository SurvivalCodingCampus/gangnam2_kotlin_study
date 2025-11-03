package com.sesac.practice.day05

import org.junit.Assert.assertEquals
import org.junit.Test

class WizardTest {
    @Test
    fun `Wizard를 생성한다`() {
        // given
        val name = "wizard"

        // when
        val wizard = Wizard(name)

        // then
        assertEquals(name, wizard.name)
        assertEquals(Hero.MAX_HP, wizard.hp)
        assertEquals(Wizard.MAX_MP, wizard.mp)
    }

    @Test
    fun `Wizard가 heal 사용시 mp가 소모된다`() {
        // given
        val wizard = Wizard("wizard")
        val originMp = wizard.mp

        val hero = Hero("hero")

        // when
        wizard.heal(hero)

        // then
        assertEquals(originMp - Wizard.HEAL_COST, wizard.mp)
    }

    @Test
    fun `Wizard가 heal 사용시 mp가 부족할 경우 대상 hp가 회복되지 않는다`() {
        // given
        val wizardMp = Wizard.HEAL_COST - 1
        val wizard = Wizard("wizard", wizardMp)

        val heroHp = 10
        val hero = Hero("hero", heroHp)

        // when
        wizard.heal(hero)

        // then
        assertEquals(heroHp, hero.hp)
    }

    @Test
    fun `Wizard가 heal 사용시 대상 hp가 회복된다`() {
        // given
        val wizard = Wizard("wizard")

        val hp = 10
        val hero = Hero("hero", hp)

        // when
        wizard.heal(hero)

        // then
        assertEquals(hp + Wizard.HEAL_AMOUNT, hero.hp)
    }

    @Test
    fun `Wizard가 heal 사용시 대상 hp가 최대 hp까지 회복된다`() {
        // given
        val wizard = Wizard("wizard")

        val hp = Hero.MAX_HP
        val hero = Hero("hero", hp)

        // when
        wizard.heal(hero)

        // then
        assertEquals(Hero.MAX_HP, hero.hp)
    }
}
