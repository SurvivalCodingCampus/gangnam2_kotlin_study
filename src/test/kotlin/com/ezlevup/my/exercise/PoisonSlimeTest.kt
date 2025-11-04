package com.ezlevup.my.exercise

import org.junit.Assert.assertEquals
import org.junit.Test

class PoisonSlimeTest {
    @Test
    fun `PoisonSlime 생성자`() {
        //given
        val suffix = "A"
        val slime = PoisonSlime(suffix)

        // then
        assertEquals(suffix, slime.suffix)
        assertEquals(PoisonSlime.MAX_POISON_COUNT, slime.poisonCount)
    }

    @Test
    fun `PoisonSlime 기본 공격`() {
        //given
        val suffix = "A"
        val slime = PoisonSlime(suffix)

        val name = "lee"
        val hp = Hero.MAX_HP
        val hero = Hero(name = name, hp = hp)

        // when
        slime.attack(hero)

        // then
        var expectedHp: Int = Hero.MAX_HP - Slime.BASE_DAMAGE - slime.calculateDamage(hero)
        if (expectedHp < 0) {
            expectedHp = 0
        }
        assertEquals(expectedHp, hero.hp)
    }


}