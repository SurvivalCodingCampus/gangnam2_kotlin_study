package com.ezlevup.my.exercise

import org.junit.Assert.assertEquals
import org.junit.Test

class SlimeTest {
    @Test
    fun `Slime 생성자`() {
        //given
        val suffix = "A"
        val slime = Slime(suffix)

        // then
        assertEquals(suffix, slime.suffix)
    }

    @Test
    fun `Slime 기본 공격`() {
        //given
        val suffix = "A"
        val slime = Slime(suffix)

        val name = "lee"
        val hp = Hero.MAX_HP
        val hero = Hero(name = name, hp = hp)

        // when
        slime.attack(hero)

        // then
        assertEquals(Hero.MAX_HP - Slime.BASE_DAMAGE, hero.hp)
    }

    @Test
    fun `Slime 기본 반복 공격`() {
        //given
        val suffix = "A"
        val slime = Slime(suffix)

        val name = "lee"
        val hp = Hero.MAX_HP
        val hero = Hero(name = name, hp = hp)

        // when
        val attackCount = (1..10).random()
        repeat(attackCount) {
            slime.attack(hero)
        }

        // then
        var expectedHp: Int = Hero.MAX_HP - (Slime.BASE_DAMAGE * attackCount)
        if (expectedHp < 0) {
            expectedHp = 0
        }
        assertEquals(expectedHp, hero.hp)
    }

}
