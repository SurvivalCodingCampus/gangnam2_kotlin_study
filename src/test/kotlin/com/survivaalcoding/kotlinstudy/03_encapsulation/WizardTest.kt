package com.survivaalcoding.kotlinstudy.`03_encapsulation`

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
}