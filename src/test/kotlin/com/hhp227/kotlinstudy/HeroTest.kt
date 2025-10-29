package com.hhp227.kotlinstudy

import com.hhp227.kotlinstudy.`02_instance_class`.Hero
import junit.framework.TestCase.assertEquals
import org.junit.Test

class HeroTest {

    @Test
    fun `Hero의 attack() 메서드를 실행하면 hp가 10만큼 줄어든다`() {
        // given (준비)
        val hero = Hero(hp = 100)

        // when (실행)
        hero.attack()

        // then (검증)
        assertEquals(90, hero.hp)
    }

    @Test
    fun `hp가 0 일때는 attack()을 해도 0이어야 함`() {
        // given (준비)
        val hero = Hero(hp = 0)

        // when (실행)
        hero.attack()

        // then (검증)
        assertEquals(0, hero.hp)
    }
}