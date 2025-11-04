package com.survivaalcoding.kotlinstudy.`05_inheritance`.example

import com.survivaalcoding.kotlinstudy.`05_inheritance`.Hero
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class WizardTest {
    @Test
    fun `마법사 이름은 빈 문자일 수 없다`() {
        // given
        // when
        // then
        assertThatThrownBy { Wizard("", Wizard.MIN_HP, Wizard.MIN_MP) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름은 빈 문자 혹은 공백일 수 없습니다.")
    }

    @Test
    fun `마법사 이름은 공백일 수 없다`() {
        // given
        // when
        // then
        assertThatThrownBy { Wizard(" ", Wizard.MIN_HP, Wizard.MIN_MP) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름은 빈 문자 혹은 공백일 수 없습니다.")
    }

    @Test
    fun `마법사 이름 경계값`() {
        // given
        val nameLength3 = Wizard("마법사", Wizard.MIN_HP, Wizard.MIN_MP)
        val nameLength4 = Wizard("마법사다", Wizard.MIN_HP, Wizard.MIN_MP)

        // when
        // then
        assertThatThrownBy { Wizard("법사", Wizard.MIN_HP, Wizard.MIN_MP) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름은 ${Wizard.NAME_LENGTH_RULE}자 이상이어야 합니다.")
        assertThat(nameLength3).isNotNull
        assertThat(nameLength4).isNotNull
    }

    @Test
    fun `마법사 HP 경계값`() {
        // given
        val name = "마법사"
        val negativeHp = -1
        val initHp = 1

        val wizard1 = Wizard(name, negativeHp, Wizard.MIN_MP)
        val wizard2 = Wizard(name, Wizard.MIN_HP, Wizard.MIN_MP)
        val wizard3 = Wizard(name, initHp, Wizard.MIN_MP)

        // when
        // then
        assertThat(wizard1.hp).isEqualTo(Wizard.MIN_HP)
        assertThat(wizard2.hp).isEqualTo(Wizard.MIN_HP)
        assertThat(wizard3.hp).isEqualTo(initHp)
    }

    @Test
    fun `마법사 MP 경계값`() {
        // given
        val name = "마법사"
        val negativeMp = -1
        val initMp = 1

        val minMp = Wizard(name, Wizard.MIN_HP, Wizard.MIN_MP)
        val minMpGreaterThan = Wizard(name, Wizard.MIN_HP, initMp)

        // when
        // then
        assertThatThrownBy { Wizard(name, Wizard.MIN_HP, negativeMp) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("MP는 최소 ${Wizard.MIN_MP} 이상이어야 합니다.")
        assertThat(minMp.mp).isEqualTo(Wizard.MIN_MP)
        assertThat(minMpGreaterThan.mp).isEqualTo(initMp)
    }

    @Test
    fun `힐 스킬을 사용하면 HP가 증가하고 MP가 감소한다`() {
        // given
        val heroName = "히어로"
        val wizardName = "마법사"
        val halfHp = Hero.MAX_HP / 2

        val hero = Hero(heroName, halfHp)
        val wizard = Wizard(wizardName, Wizard.MAX_HP)

        // when
        wizard.heal(hero)

        // then
        assertThat(hero.hp).isEqualTo(halfHp + Wizard.HEAL_HP_RECOVERY)
        assertThat(wizard.mp).isEqualTo(Wizard.MAX_MP - Wizard.HEAL_MP_COST)
    }

    @Test
    fun `마나가 부족하면 힐 스킬을 사용하지 못해 HP가 증가하지 않고 MP가 감소하지 않는다`() {
        // given
        val heroName = "히어로"
        val wizardName = "마법사"
        val halfHp = Hero.MAX_HP / 2
        val hasFourMp = 4

        val hero = Hero(heroName, halfHp)
        val wizard = Wizard(wizardName, Wizard.MAX_HP, hasFourMp)

        // when
        wizard.heal(hero)

        // then
        assertThat(hero.hp).isEqualTo(halfHp)
        assertThat(wizard.mp).isEqualTo(hasFourMp)
    }

    @Test
    fun `스킬을 사용하면 마나가 감소한다`() {
        // given
        val name = "마법사"

        val wizard = Wizard(name, Wizard.MAX_HP)

        // when
        wizard.useUpMp(Wizard.HEAL_MP_COST)

        // then
        assertThat(wizard.mp).isEqualTo(Wizard.MAX_MP - Wizard.HEAL_MP_COST)
    }
}