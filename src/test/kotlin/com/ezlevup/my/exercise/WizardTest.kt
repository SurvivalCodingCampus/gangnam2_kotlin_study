package com.ezlevup.my.exercise

import org.junit.Assert.*
import org.junit.Test

class WizardTest {
    @Test
    fun `마법사 이름만 지정해서 인스턴스 초기값 확인`() {
        // given
        val name = "lee"
        val hp = 10
        val wizard = Wizard(name = name, hp = hp, wand = null)

        // then
        assertEquals(name, wizard.name)
        assertEquals(hp, wizard.hp)
    }

    @Test
    fun `마법사 정상적인 mp`() {
        // given
        val name = "lee"
        val hp = 10
        val testMp = 1
        val wizard = Wizard(name = name, hp = hp, wand = null)

        // when
        wizard.mp = testMp

        // then
        assertEquals(testMp, wizard.mp)
    }


    @Test
    fun `마법사 mp 0이하`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            // given
            val name = "lee"
            val hp = 10
            val wand = Wizard(name = name, hp = hp, wand = null)

            // when
            wand.mp = -1
        }
        // then
        assertTrue(exception.message?.contains("마법사의 MP는") ?: false)
    }

    @Test
    fun `마법사 hp가 음수가 되는 상황 1`() {
        // given
        val name = "lee"
        val hp = 10
        val testMp = 1
        val testHp = -1
        val wizard = Wizard(name = name, hp = testHp, wand = null)

        // then
        assertEquals(0, wizard.hp)
    }


    /**
     * HP가 음수가 되는 상황에서는 대신 0을 설정 되도록 한다.
     */
    @Test
    fun `마법사 hp가 음수가 되는 상황 2`() {
        // given
        val name = "lee"
        val hp = 10
        val testHp = -1
        val wizard = Wizard(name = name, hp = hp, wand = null)

        // when
        wizard.hp = testHp

        // then
        assertEquals(0, wizard.hp)
    }

    @Test
    fun `마법사 힐 시전`() {
        // given
        val wizardName = "lee"
        val wizardHp = 100
        val wizard = Wizard(name = wizardName, hp = wizardHp, wand = null)

        val heroName = "lee"
        val heroHp = 1
        val hero = Hero(name = heroName, hp = heroHp)

        // when
        wizard.heal(hero)

        // then
        assertEquals(heroHp + Wizard.HEAL_HP, hero.hp)
    }

    @Test
    fun `마법사 힐 시전 마나 부족`() {
        // given
        val wizardName = "lee"
        val wizardHp = 100
        val wizard = Wizard(name = wizardName, hp = wizardHp, wand = null)
        wizard.mp = Wizard.MP_COST - 1

        val heroName = "lee"
        val heroHp = 1
        val hero = Hero(name = heroName, hp = heroHp)

        // when
        wizard.heal(hero)

        // then
        assertEquals(heroHp, hero.hp)
    }
}