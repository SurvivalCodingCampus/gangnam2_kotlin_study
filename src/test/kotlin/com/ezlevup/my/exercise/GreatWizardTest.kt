package com.ezlevup.my.exercise

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class GreatWizardTest {
    @Test
    fun `위대한마법사 이름만 지정해서 인스턴스 초기값 확인`() {
        // given
        val name = "lee"
        val hp = 10
        val wizard = GreatWizard(name = name, hp = hp, wand = null)

        // then
        assertEquals(name, wizard.name)
        assertEquals(hp, wizard.hp)
    }

    @Test
    fun `위대한마법사 정상적인 mp`() {
        // given
        val name = "lee"
        val hp = 10
        val testMp = 1
        val wizard = GreatWizard(name = name, hp = hp, wand = null)

        // when
        wizard.mp = testMp

        // then
        assertEquals(testMp, wizard.mp)
    }

    @Test
    fun `위대한마법사 mp 0이하`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            // given
            val name = "lee"
            val hp = 10
            val wand = GreatWizard(name = name, hp = hp, wand = null)

            // when
            wand.mp = -1
        }
    }

    @Test
    fun `위대한마법사 힐 시전`() {
        // given
        val wizardName = "lee"
        val wizardHp = 100
        val wizard = GreatWizard(name = wizardName, hp = wizardHp, wand = null)

        val heroName = "lee"
        val heroHp = 1
        val hero = Hero(name = heroName, hp = heroHp)

        // when
        wizard.heal(hero)

        // then
        assertEquals(heroHp + GreatWizard.HEAL_HP, hero.hp)
    }

    @Test
    fun `위대한마법사 힐 시전 마나 부족`() {
        // given
        val wizardName = "lee"
        val wizardHp = 100
        val wizard = GreatWizard(name = wizardName, hp = wizardHp, wand = null)
        wizard.mp = GreatWizard.SUPER_HEAL_MP_COST - 1

        val heroName = "lee"
        val heroHp = 1
        val hero = Hero(name = heroName, hp = heroHp)

        // when
        wizard.heal(hero)

        // then
        assertEquals(heroHp, hero.hp)
    }

    @Test
    fun `위대한마법사 슈퍼 힐 시전`() {
        // given
        val wizardName = "lee"
        val wizardHp = 100
        val wizard = GreatWizard(name = wizardName, hp = wizardHp, wand = null)

        val heroName = "lee"
        val heroHp = 1
        val hero = Hero(name = heroName, hp = heroHp)

        // when
        wizard.superHeal(hero)

        // then
        assertEquals(Hero.MAX_HP, hero.hp)
    }
}