package com.survivaalcoding.kotlinstudy.`02_instance_class`.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ClericTest {
    @Test
    fun `회복 마법을 사용하면 HP 10 증가하고 MP 5 감소한다`() {
        // given
        val cleric = Cleric("클레릭", 20)

        // when
        cleric.selfAid()

        // then
        assertThat(cleric.hp).isEqualTo(30)
        assertThat(cleric.mp).isEqualTo(5)
    }

    @Test
    fun `MP가 5 미만이면 회복 마법을 사용하지 못한다`() {
        // given
        val cleric = Cleric("클레릭", 20, 4)

        // when
        cleric.selfAid()

        // then
        assertThat(cleric.hp).isEqualTo(20)
        assertThat(cleric.mp).isEqualTo(4)
    }

    @Test
    fun `HP가 최대 HP를 넘기지 않는다`() {
        // given
        val cleric = Cleric("클레릭", 45)

        // when
        cleric.selfAid()

        // then
        assertThat(cleric.hp).isEqualTo(50)
        assertThat(cleric.mp).isEqualTo(5)
    }

    @Test
    fun `기도 마법 사용하면 MP를 회복한다`() {
        // given
        val cleric = Cleric("클레릭", mp = 5)

        // when
        cleric.pray(2)

        // then
        assertThat(cleric.mp).isGreaterThan(5)
    }

    @Test
    fun `MP가 최대 MP를 넘기지 않는다`() {
        // given
        val cleric = Cleric("클레릭", mp = 8)

        // when
        cleric.pray(5)

        // then
        assertThat(cleric.mp).isEqualTo(10)
    }
}