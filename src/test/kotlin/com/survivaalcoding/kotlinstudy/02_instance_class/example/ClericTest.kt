package com.survivaalcoding.kotlinstudy.`02_instance_class`.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ClericTest {
    @Test
    fun `클레릭 생성 시 HP는 50, MP는 10이다`() {
        // given
        val name = "클레릭"
        val hp = 50
        val mp = 10

        // when
        val cleric = Cleric(name)

        // then
        assertThat(cleric)
            .extracting("name", "hp", "mp")
            .contains(name, hp, mp)
    }

    @Test
    fun `회복 마법을 사용하면 HP 10 증가하고 MP 5 감소한다`() {
        // given
        val name = "클레릭"

        val cleric = Cleric(name, 20)

        // when
        cleric.selfAid()

        // then
        assertThat(cleric.hp).isEqualTo(30)
        assertThat(cleric.mp).isEqualTo(5)
    }

    @Test
    fun `MP가 5 미만이면 회복 마법을 사용하지 못한다`() {
        // given
        val name = "클레릭"
        val cleric = Cleric(name, 20, 4)

        // when
        cleric.selfAid()

        // then
        assertThat(cleric.hp).isEqualTo(20)
        assertThat(cleric.mp).isEqualTo(4)
    }

    @Test
    fun `HP가 최대 HP를 넘기지 않는다`() {
        // given
        val maxHp = 50
        val name = "클레릭"
        val cleric = Cleric(name, 45)

        // when
        cleric.selfAid()

        // then
        assertThat(cleric.hp).isEqualTo(maxHp)
        assertThat(cleric.mp).isEqualTo(5)
    }

    @Test
    fun `기도 마법 사용하면 MP를 회복한다`() {
        // given
        val name = "클레릭"
        val cleric = Cleric(name, mp = 5)

        // when
        cleric.pray(2)

        // then
        assertThat(cleric.mp).isGreaterThan(5)
    }

    @Test
    fun `MP가 최대 MP를 넘기지 않는다`() {
        // given
        val maxMp = 10
        val name = "클레릭"
        val cleric = Cleric(name, mp = 8)

        // when
        cleric.pray(5)

        // then
        assertThat(cleric.mp).isEqualTo(maxMp)
    }
}