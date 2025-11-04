package com.survivaalcoding.kotlinstudy.`05_inheritance`.example

import com.survivaalcoding.kotlinstudy.`05_inheritance`.Hero
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SlimeTest {
    @Test
    fun `슬라임 suffix 지정하고 생성 시 지정한 명칭으로 생성되어야 한다`() {
        // given
        val suffix = "A"

        // when
        val slime = Slime(suffix)

        // then
        assertThat(slime.suffix).isEqualTo(suffix)
    }

    @Test
    fun `슬라임 공격 시 히어로의 HP가 10 감소해야 한다`() {
        // given
        val name = "히어로"
        val suffix = "A"

        val hero = Hero(name)
        val slime = Slime(suffix)

        // when
        slime.attack(hero)

        // then
        assertThat(hero.hp).isEqualTo(Hero.MAX_HP - Slime.ATTACK_POINT)
    }
}