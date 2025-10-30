package com.neouul.sesac.`02-instance-class`

import org.junit.Test
import kotlin.test.assertEquals

class HeroTest {
    @Test
    fun `Hero의 attack() 메서드를 실행하면 hp가 10만큼 줄어든다`(){
        // given (준비)
        val hero = Hero(hp = 100)

        // when (실행)
        hero.attack()

        // then (검증)
        assertEquals(90, hero.hp)
    }
}