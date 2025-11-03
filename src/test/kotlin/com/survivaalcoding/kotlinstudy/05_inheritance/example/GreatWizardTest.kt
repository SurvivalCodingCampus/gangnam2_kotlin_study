package com.survivaalcoding.kotlinstudy.`05_inheritance`.example

import com.survivaalcoding.kotlinstudy.`05_inheritance`.Hero
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GreatWizardTest {
    @Test
    fun `스킬을 사용하면 마나가 감소한다`() {
        // given
        val name = "마법사"

        val greatWizard = GreatWizard(name, Wizard.MAX_HP)

        // when
        greatWizard.useUpMp(GreatWizard.HEAL_MP_COST)

        // then
        assertThat(greatWizard.mp).isEqualTo(GreatWizard.MAX_MP - GreatWizard.HEAL_MP_COST)
    }

    @Test
    fun `힐 스킬을 사용하면 HP가 증가하고 MP가 감소한다`() {
        // given
        val heroName = "히어로"
        val wizardName = "마법사"
        val halfHp = Hero.MAX_HP / 2

        val hero = Hero(heroName, halfHp)
        val greatWizard = GreatWizard(wizardName, Wizard.MAX_HP)

        // when
        greatWizard.heal(hero)

        // then
        assertThat(hero.hp).isEqualTo(halfHp + GreatWizard.HEAL_HP_RECOVERY)
        assertThat(greatWizard.mp).isEqualTo(GreatWizard.MAX_MP - GreatWizard.HEAL_MP_COST)
    }

    @Test
    fun `마나가 부족하면 힐 스킬을 사용하지 못해 HP가 증가하지 않고 MP가 감소하지 않는다`() {
        // given
        val heroName = "히어로"
        val wizardName = "마법사"
        val halfHp = Hero.MAX_HP / 2
        val hasFourMp = 4

        val hero = Hero(heroName, halfHp)
        val greatWizard = GreatWizard(wizardName, Wizard.MAX_HP, hasFourMp)

        // when
        greatWizard.heal(hero)

        // then
        assertThat(hero.hp).isEqualTo(halfHp)
        assertThat(greatWizard.mp).isEqualTo(hasFourMp)
    }

    @Test
    fun `슈퍼 힐 스킬을 사용하면 HP는 Full HP, MP는 감소한다`() {
        // given
        val heroName = "히어로"
        val wizardName = "마법사"
        val halfHp = Hero.MAX_HP / 2

        val hero = Hero(heroName, halfHp)
        val greatWizard = GreatWizard(wizardName, Wizard.MAX_HP)

        // when
        greatWizard.superHeal(hero)

        // then
        assertThat(hero.hp).isEqualTo(Hero.MAX_HP)
        assertThat(greatWizard.mp).isEqualTo(GreatWizard.MAX_MP - GreatWizard.SUPER_HEAL_MP_COST)
    }

    @Test
    fun `마나가 부족하면 슈퍼 힐 스킬을 사용하지 못해 HP가 증가하지 않고 MP가 감소하지 않는다`() {
        // given
        val heroName = "히어로"
        val wizardName = "마법사"
        val halfHp = Hero.MAX_HP / 2
        val moreLessThanSuperHealMpCost = 40

        val hero = Hero(heroName, halfHp)
        val greatWizard = GreatWizard(wizardName, Wizard.MAX_HP, moreLessThanSuperHealMpCost)

        // when
        greatWizard.superHeal(hero)

        // then
        assertThat(hero.hp).isEqualTo(halfHp)
        assertThat(greatWizard.mp).isEqualTo(moreLessThanSuperHealMpCost)
    }
}