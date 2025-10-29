package com.ezlevup.my.day03

import org.junit.Test
import kotlin.test.assertEquals

class HeroTest {
    @Test
    fun `Hero의 attack() 메서드를 실행하면 hp가 10만큼 줄어든다`() {
        // given(준비)
        val hero = Hero(name = "lee", hp = 100)

        // when(실행)
        hero.attack()

        // then(검증)
        assertEquals(90, hero.hp)
    }

    @Test
    fun `hp가 0일때 attack()을 해도 0이어야함`() {
        // given
        val hero = Hero(name = "lee", hp = 0)

        // when
        hero.attack()

        // then
        assertEquals(0, hero.hp)
    }
}