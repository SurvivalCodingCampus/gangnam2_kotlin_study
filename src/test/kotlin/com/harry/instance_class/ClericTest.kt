package com.harry.instance_class

import org.junit.Assert.*
import org.junit.jupiter.api.Test
import kotlin.test.assertIs

class ClericTest {
    @Test
    fun `성직자 생성 테스트`() {
        // given (테스트 시 전역으로 올려도 될 것 같음)
        val clericHong = Cleric(
            name = "홍길동",
            hp = 30,
            mp = 8,
        )
        // when ?
        // then
        assertIs<Cleric>(clericHong)
    }

    @Test
    fun `성직자 자기 치료 테스트`() {
        // given
        val clericKim = Cleric(
            name = "김길동",
            hp = 30,
            mp = 8,
        )
        // when
        clericKim.selfAid()
        // then
        assertEquals(50,clericKim.hp)
    }

    @Test
    fun `성직자 기도 테스트`() {
        val prayTime = 3
        val clericKang = Cleric(
            name = "강길동",
            hp = 30,
            mp = 8,
        )
        val prayResult = clericKang.pray(prayTime)
        assertEquals(0,prayResult)
    }
}