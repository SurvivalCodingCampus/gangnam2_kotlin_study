package com.survivaalcoding.kotlinstudy.`03_encapsulation`.example

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class WandTest {
    @Test
    fun `지팡이 이름은 빈 문자일 수 없다`() {
        // given
        // when
        // then
        assertThatThrownBy { Wand("", Wand.MIN_POWER) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름은 빈 문자 혹은 공백일 수 없습니다.")
    }

    @Test
    fun `지팡이 이름은 공백일 수 없다`() {
        // given
        // when
        // then
        assertThatThrownBy { Wand(" ", Wand.MIN_POWER) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름은 빈 문자 혹은 공백일 수 없습니다.")
    }

    @Test
    fun `지팡이 이름 경계값`() {
        // given
        val nameLength3 = Wand("지팡이", Wand.MIN_POWER)
        val nameLength4 = Wand("지팡이다", Wand.MIN_POWER)

        // when
        // then
        assertThatThrownBy { Wand("팡이", Wand.MIN_POWER) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름은 ${Wand.NAME_LENGTH_RULE}자 이상이어야 합니다.")
        assertThat(nameLength3).isNotNull
        assertThat(nameLength4).isNotNull
    }

    @Test
    fun `지팡이 마력 하한 경계값`() {
        // given
        val name = "초보자 지팡이"

        val minPower = Wand(name, Wand.MIN_POWER)
        val minPowerGreaterThan = Wand(name, 0.6)

        // when
        // then
        assertThatThrownBy { Wand(name, 0.4) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("마력은 ${Wand.MIN_POWER} ~ ${Wand.MAX_POWER} 범위까지만 지정 가능합니다.")
        assertThat(minPower).isNotNull
        assertThat(minPowerGreaterThan).isNotNull
    }

    @Test
    fun `지팡이 마력 상한 경계값`() {
        // given
        val name = "초보자 지팡이"

        val maxPowerLessThan = Wand(name, 99.9)
        val maxPower = Wand(name, Wand.MAX_POWER)

        // when
        // then
        assertThat(maxPowerLessThan).isNotNull
        assertThat(maxPower).isNotNull
        assertThatThrownBy { Wand(name, 100.1) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("마력은 ${Wand.MIN_POWER} ~ ${Wand.MAX_POWER} 범위까지만 지정 가능합니다.")
    }
}