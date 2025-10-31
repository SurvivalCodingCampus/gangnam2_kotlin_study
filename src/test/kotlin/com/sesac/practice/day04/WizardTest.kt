package com.sesac.practice.day04

import org.junit.Test
import kotlin.test.assertEquals

class WizardTest {
    @Test
    fun `Wizard를 생성한다`() {
        // given
        val name = "wizard"
        val hp = 10
        val mp = 10
        val wand = Wand("wand", 1.1)

        // when
        val wizard = Wizard(name, hp, mp, wand)

        // then
        assertEquals(name, wizard.name)
        assertEquals(hp, wizard.hp)
        assertEquals(mp, wizard.mp)
        assertEquals(wand, wizard.wand)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Wizard 이름이 3자 미만일 경우 에러가 발생한다`() {
        // given
        val name = "ab"
        val hp = 10
        val mp = 10
        val wand = Wand("wand", 1.1)

        // when // then
        Wizard(name, hp, mp, wand)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Wizard mp가 음수일 경우 에러가 발생한다`() {
        // given
        val name = "wizard"
        val hp = 10
        val mp = -1
        val wand = Wand("wand", 1.1)

        // when // then
        Wizard(name, hp, mp, wand)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Wizard mp가 음수로 설정할 경우 에러가 발생한다`() {
        // given
        val name = "wizard"
        val hp = 10
        val mp = 10
        val wand = Wand("wand", 1.1)

        val wizard = Wizard(name, hp, mp, wand)

        // when // then
        wizard.mp = -1
    }

    @Test
    fun `Wizard hp가 음수일 경우 0으로 설정된다`() {
        // given
        val name = "wizard"
        val hp = -1
        val mp = 10
        val wand = Wand("wand", 1.1)

        // when
        val wizard = Wizard(name, hp, mp, wand)

        // then
        assertEquals(0, wizard.hp)
    }

    @Test
    fun `Wizard hp가 음수가 될 경우 0으로 설정된다`() {
        // given
        val name = "wizard"
        val hp = 10
        val mp = 10
        val wand = Wand("wand", 1.1)

        val wizard = Wizard(name, hp, mp, wand)

        // when
        wizard.hp = -1

        // then
        assertEquals(0, wizard.hp)
    }
}
