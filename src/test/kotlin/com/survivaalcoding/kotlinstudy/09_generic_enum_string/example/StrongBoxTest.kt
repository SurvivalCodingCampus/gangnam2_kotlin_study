package com.survivaalcoding.kotlinstudy.`09_generic_enum_string`.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class StrongBoxTest {
    @Test
    fun `정수형 금고를 생성할 수 있다`() {
        // given
        val expected = 10

        // when
        val integerStrongBox: StrongBox<Int> = StrongBox(expected)

        // then
        assertThat(integerStrongBox.value).isEqualTo(expected)
    }

    @Test
    fun `실수형 금고를 생성할 수 있다`() {
        // given
        val expected = 10.0

        // when
        val doubleStrongBox: StrongBox<Double> = StrongBox(expected)

        // then
        assertThat(doubleStrongBox.value).isEqualTo(expected)
    }

    @Test
    fun `문자열형 금고를 생성할 수 있다`() {
        // given
        val expected = "Hi"

        // when
        val doubleStrongBox: StrongBox<String> = StrongBox(expected)

        // then
        assertThat(doubleStrongBox.value).isEqualTo(expected)
    }
}