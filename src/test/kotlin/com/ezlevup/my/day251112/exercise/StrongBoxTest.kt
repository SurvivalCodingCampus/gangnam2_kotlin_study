package com.ezlevup.my.day251112.exercise

import org.junit.Assert.assertEquals
import org.junit.Test

class StrongBoxTest {
    @Test
    fun `금고 Int 타입 담기`() {
        // given
        val box = StrongBox<Int>()

        // when
        val data: Int = 100
        box.put(data)
        val i: Int? = box.get()

        // then
        assertEquals(data, i)
    }

    @Test
    fun `금고 String 타입 담기`() {
        // given
        val box = StrongBox<String>()

        // when
        val data: String = "lee"
        box.put(data)
        val result: String? = box.get()

        // then
        assertEquals(data, result)
    }


    @Test
    fun `금고 사용자 데이터 타입 담기`() {
        // given
        data class Lee(val hp: Int) {}

        val box = StrongBox<Lee>()

        // when
        val data: Lee = Lee(100)
        box.put(data)
        val result: Lee? = box.get()

        // then
        assertEquals(data, result)
    }


}