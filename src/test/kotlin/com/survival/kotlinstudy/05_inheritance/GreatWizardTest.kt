package com.survival.kotlinstudy.`05_inheritance`

import com.survival.kotlinstudy.`02_instance_class`.Hero
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNull

class GreatWizardTest {

    @Test
    fun `GreatWizard 인스턴스 생성`() {
        // given (준비)
        val wizardName = "대마법사"
        val wizardHp = 100
        val wizard = GreatWizard(name = wizardName, hp = wizardHp, wand = null)

        // when (실행)

        // then (검증)
        assertIs<GreatWizard>(wizard)
        assertEquals(wizardName, wizard.name)
        assertEquals(wizardHp, wizard.hp)
        assertNull(wizard.wand)
    }

    @Test
    fun `GreatWizard 인스턴스 생성 후 초기 MP 테스트`() {
        // given (준비)
        val wizardName = "대마법사"
        val wizardHp = 100
        val wizard = GreatWizard(name = wizardName, hp = wizardHp, wand = null)

        // when (실행)

        // then (검증)
        assertEquals(GreatWizard.INIT_MP, wizard.mp)
    }

    @Test
    fun `GreatWizard heal 테스트 - 정상 작동하는지`() {
        // given (준비)
        val wizardName = "대마법사"
        val wizardHp = 100
        val heroName = "영웅"
        val heroHp = 20
        val wizard = GreatWizard(name = wizardName, hp = wizardHp, wand = null)
        val hero = Hero(name = heroName, hp = heroHp)

        // when (실행)
        wizard.heal(hero)

        // then (검증)
        assertEquals(GreatWizard.INIT_MP - GreatWizard.HEAL_COST, wizard.mp)
        assertEquals(heroHp + GreatWizard.HEAL_HP, hero.hp)
    }

    @Test
    fun `GreatWizard heal 테스트 - mp가 부족할 경우`() {
        // given (준비)
        val wizardName = "대마법사"
        val wizardHp = 100
        val heroName = "영웅"
        val zeroMp = 0
        val heroHp = 20
        val wizard = GreatWizard(name = wizardName, hp = wizardHp, wand = null)
        val hero = Hero(name = heroName, hp = heroHp)

        // when (실행)
        wizard.mp = zeroMp
        wizard.heal(hero)

        // then (검증)
        assertEquals(zeroMp, wizard.mp)
        assertEquals(heroHp, hero.hp)
    }

    @Test
    fun `GreatWizard superHeal 테스트 - 정상 작동하는지`() {
        // given (준비)
        val wizardName = "대마법사"
        val wizardHp = 100
        val heroName = "영웅"
        val heroHp = 20
        val wizard = GreatWizard(name = wizardName, hp = wizardHp, wand = null)
        val hero = Hero(name = heroName, hp = heroHp)

        // when (실행)
        wizard.superHeal(hero)

        // then (검증)
        assertEquals(GreatWizard.INIT_MP - GreatWizard.SUPER_HEAL_COST, wizard.mp)
        assertEquals(Hero.MAX_HP, hero.hp)
    }

    @Test
    fun `GreatWizard superHeal 테스트 - mp가 부족한 경우`() {
        // given (준비)
        val wizardName = "대마법사"
        val wizardHp = 100
        val heroName = "영웅"
        val heroHp = 20
        val zeroMp = 0
        val wizard = GreatWizard(name = wizardName, hp = wizardHp, wand = null)
        val hero = Hero(name = heroName, hp = heroHp)

        // when (실행)
        wizard.mp = zeroMp
        wizard.superHeal(hero)

        // then (검증)
        assertEquals(zeroMp, wizard.mp)
        assertEquals(heroHp, hero.hp)
    }

}