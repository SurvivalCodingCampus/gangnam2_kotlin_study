package com.survivaalcoding.kotlinstudy.`05_inheritance`.example

import com.survivaalcoding.kotlinstudy.`05_inheritance`.Hero
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PoisonSlimeTest {
    @Test
    fun `독 슬라임 suffix 지정하고 생성 시 지정한 명칭으로 생성되어야 한다`() {
        // given
        val suffix = "A"

        // when
        val poisonSlime = PoisonSlime(suffix)

        // then
        assertThat(poisonSlime.suffix).isEqualTo(suffix)
    }

    @Test
    fun `독 슬라임 생성 시 독 공격 가능 횟수 초기화가 돼야 한다`() {
        // given
        val suffix = "A"

        // when
        val poisonSlime = PoisonSlime(suffix)

        // then
        assertThat(poisonSlime.poisonCount).isEqualTo(PoisonSlime.AVAILABLE_POISON_ATTACK_COUNT)
    }

    @Test
    fun `기본 공격, 독 공격 시 히어로의 HP가 감소해야 한다`() {
        // given
        val name = "히어로"
        val suffix = "A"
        val poisonDamage = Hero.MAX_HP / PoisonSlime.POISON_ATTACK_POINT

        val hero = Hero(name)
        val poisonSlime = PoisonSlime(suffix)

        // when
        poisonSlime.attack(hero)

        // then
        assertThat(hero.hp).isEqualTo(Hero.MAX_HP - Slime.ATTACK_POINT - poisonDamage)
    }

    @Test
    fun `독 공격 횟수가 없으면 기본 공격 포인트만 히어로의 HP가 감소해야 한다`() {
        // given
        val name = "히어로"
        val suffix = "A"

        val hero = Hero(name)
        val poisonSlime = PoisonSlime(suffix)
        poisonSlime.poisonCount = PoisonSlime.UNAVAILABLE_POISON_ATTACK_COUNT

        // when
        poisonSlime.attack(hero)
        
        // then
        assertThat(hero.hp).isEqualTo(Hero.MAX_HP - Slime.ATTACK_POINT)
    }

    @Test
    fun `슬라임이 기본 공격 시 히어로가 죽으면 독 공격은 하지 않는다`() {
        // given
        val name = "히어로"
        val suffix = "A"
        val oneShotHp = 5

        val hero = Hero(name, oneShotHp)
        val poisonSlime = PoisonSlime(suffix)

        // when
        poisonSlime.attack(hero)

        // then
        assertThat(hero.hp).isEqualTo(Hero.MIN_HP)
    }

    @Test
    fun `슬라임은 시체를 공격 하지 않는다`() {
        // given
        val name = "히어로"
        val suffix = "A"

        val hero = Hero(name, Hero.MIN_HP)
        val poisonSlime = PoisonSlime(suffix)

        // when
        poisonSlime.attack(hero)

        // then
        assertThat(hero.hp).isEqualTo(Hero.MIN_HP)
    }
}