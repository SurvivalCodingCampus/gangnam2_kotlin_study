package com.survivaalcoding.kotlinstudy.`02_instance_class`.example

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
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
    fun `클레릭 생성 시 HP 지정값 10으로 초기화된다`() {
        // given
        val name = "클레릭"
        val hp = 10
        val mp = 10

        // when
        val cleric = Cleric(name, hp)

        // then
        assertThat(cleric)
            .extracting("name", "hp", "mp")
            .contains(name, hp, mp)
    }

    @Test
    fun `클레릭 생성 시 MP 지정값 5로 초기화된다`() {
        // given
        val name = "클레릭"
        val hp = 50
        val mp = 5

        // when
        val cleric = Cleric(name, mp = mp)

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

    @Test
    fun `최대 HP, MP가 공유 필드로 선언 되었는지 확인`() {
        assertThat(Cleric.MAX_HP).isPositive
        assertThat(Cleric.MAX_MP).isPositive
    }

    @Test
    fun `회복 기능에 드는 MP 비용, HP 회복이 공유 필드로 선언 되었는지 확인`() {
        assertThat(Cleric.SELF_AID_MP_COST).isPositive
        assertThat(Cleric.SELF_AID_HP_RECOVERY).isPositive
    }

    @Test
    fun `이름, HP, MP를 지정해 인스턴스화 할 수 있다`() {
        // given
        val name = "아서스"
        val hp = 40
        val mp = 5

        // when
        val cleric = Cleric(name, hp, mp)

        // then
        assertThat(cleric)
            .extracting("name", "hp", "mp")
            .contains(name, hp, mp)
    }

    @Test
    fun `이름, HP만 지정하고 MP는 최대 MP값으로 초기화해서 인스턴스화 할 수 있다`() {
        // given
        val maxMp = 10
        val name = "아서스"
        val hp = 35

        // when
        val cleric = Cleric(name, hp)

        // then
        assertThat(cleric)
            .extracting("name", "hp", "mp")
            .contains(name, hp, maxMp)
    }

    @Test
    fun `이름만 지정하고 HP, MP는 최대 HP, MP값으로 초기화해서 인스턴스화 할 수 있다`() {
        // given
        val maxHP = 50
        val maxMp = 10
        val name = "아서스"

        // when
        val cleric = Cleric(name)

        // then
        assertThat(cleric)
            .extracting("name", "hp", "mp")
            .contains(name, maxHP, maxMp)
    }

    @Test
    fun `이름, MP만 지정하고 HP는 최대 HP값으로 초기화해서 인스턴스화 할 수 있다`() {
        // given
        val maxHP = 50
        val name = "아서스"
        val mp = 5

        // when
        val cleric = Cleric(name, mp = mp)

        // then
        assertThat(cleric)
            .extracting("name", "hp", "mp")
            .contains(name, maxHP, mp)
    }

}