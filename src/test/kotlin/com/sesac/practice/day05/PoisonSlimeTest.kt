package com.sesac.practice.day05

import org.junit.Test
import kotlin.test.assertEquals

class PoisonSlimeTest {
    @Test
    fun `PoisonSlime을 생성한다`() {
        // given
        val suffix = "A"

        // when
        val poisonSlime = PoisonSlime(suffix)

        // then
        assertEquals(suffix, poisonSlime.suffix)
        assertEquals(Slime.MAX_HP, poisonSlime.hp)
        assertEquals(PoisonSlime.POISON_COUNT, poisonSlime.poisonCount)
    }

    @Test
    fun `PoisonSlime이 공격할 경우 독 공격도 한다`() {
        // given
        val suffix = "A"
        val poisonSlime = PoisonSlime(suffix)

        val name = "hero"
        val hero = Hero(name)
        val originHeroHp = hero.hp

        // when
        poisonSlime.attack(hero)

        // then
        assertEquals(PoisonSlime.POISON_COUNT - 1, poisonSlime.poisonCount)
        assertEquals(originHeroHp - Slime.ATTACK_DAMAGE - PoisonSlime.POISON_DAMAGE, hero.hp)
    }

    @Test
    fun `PoisonSlime이 공격할 경우 독 공격 횟수가 부족하면 독 공격을 하지 않는다`() {
        // given
        val suffix = "A"
        val poisonCount = 0
        val poisonSlime = PoisonSlime(suffix, poisonCount)

        val name = "hero"
        val hero = Hero(name)
        val originHeroHp = hero.hp

        // when
        poisonSlime.attack(hero)

        // then
        assertEquals(originHeroHp - Slime.ATTACK_DAMAGE, hero.hp)
    }
}
