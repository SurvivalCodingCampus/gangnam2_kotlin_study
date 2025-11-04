package com.survivaalcoding.kotlinstudy.`05_inheritance`

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class HeroTest {
    @Test
    fun `HP가 1 이상이면 공격 대상이 될 수 있다`() {
        // given
        val name = "히어로"
        val oneShotHp = 1

        val hero = Hero(name, oneShotHp)

        // when
        val result = hero.isAvailableAttack()

        // then
        assertThat(result).isTrue
    }

    @Test
    fun `HP가 0이면 공격 대상이 될 수 없다`() {
        // given
        val name = "히어로"

        val hero = Hero(name, Hero.MIN_HP)

        // when
        val result = hero.isAvailableAttack()

        // then
        assertThat(result).isFalse
    }

    @Test
    fun `HP를 회복할 수 있다`() {
        // given
        val name = "히어로"
        val middleHp = 50
        val hpRecovery = 10

        val hero = Hero(name, middleHp)

        // when
        hero.addHp(hpRecovery)

        // then
        assertThat(hero.hp).isEqualTo(middleHp + hpRecovery)
    }

    @Test
    fun `HP 회복은 최대 HP까지만 회복할 수 있다`() {
        // given
        val name = "히어로"
        val defaultHp = 90
        val hpRecovery = 20

        val hero = Hero(name, defaultHp)

        // when
        hero.addHp(hpRecovery)

        // then
        assertThat(hero.hp).isEqualTo(Hero.MAX_HP)
    }

    @Test
    fun `HP 회복값이 음수면 예외가 발생한다`() {
        // given
        val name = "히어로"
        val negativeHpRecovery = -1

        val hero = Hero(name)

        // when
        // then
        assertThatThrownBy {
            hero.addHp(negativeHpRecovery)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}