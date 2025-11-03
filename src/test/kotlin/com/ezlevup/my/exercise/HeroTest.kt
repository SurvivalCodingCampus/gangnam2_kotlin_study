package com.ezlevup.my.exercise

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class HeroTest {
    @Test
    fun `Hero 생성자`() {
        //given
        val name = "lee"
        val hp = 100
        val hero = Hero(name = name, hp = hp)

        // then
        assertEquals(name, hero.name)
        assertEquals(hp, hero.hp)
        assertEquals(Hero.MAX_HP, hero.maxHp)
    }

    @Test
    fun `Hero 생성자 maxHp 할당`() {
        //given
        val name = "lee"
        val hp = 100
        val maxHp = 999
        val hero = Hero(name = name, hp = hp, maxHp = maxHp)

        // then
        assertEquals(name, hero.name)
        assertEquals(hp, hero.hp)
        assertEquals(maxHp, hero.maxHp)
    }

    @Test
    fun `Hero 데미지 받다`() {
        // given
        val name = "lee"
        val hp = 100
        val maxHp = 999
        val hero = Hero(name = name, hp = hp, maxHp = maxHp)

        // when
        val damage: Int = 10
        hero.takeDamage(damage)

        // then
        assertEquals(hp - damage, hero.hp)
    }

    @Test
    fun `Hero 데미지가 음수일 경우`() {
        // given
        val name = "lee"
        val hp = 100
        val maxHp = 999
        val hero = Hero(name = name, hp = hp, maxHp = maxHp)

        // when & then
        val damage: Int = -10
        val exception = assertThrows(IllegalArgumentException::class.java) {
            hero.takeDamage(damage)
        }
    }

    @Test
    fun `Hero hp 증가 값이 음수일 경우`() {
        // given
        val name = "lee"
        val hp = 100
        val maxHp = 999
        val hero = Hero(name = name, hp = hp, maxHp = maxHp)

        // when & then
        val healHp: Int = -10
        val exception = assertThrows(IllegalArgumentException::class.java) {
            hero.addHp(healHp)
        }
    }
}