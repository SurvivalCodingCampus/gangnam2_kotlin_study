package com.sesac.practice.day09.generic

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class StrongBoxTest {
    @Test
    fun `금고를 생성한다`() {
        // given
        val item = 1

        // when
        val strongBox: StrongBox<Int> = StrongBox(item)

        // then
        assertEquals(item, strongBox.get())
        assertTrue(strongBox.get() is Int)
    }

    @Test
    fun `금고에 아이템을 넣는다`() {
        // given
        val strongBox = StrongBox<String>()
        val item = "item"

        // when
        strongBox.put(item)

        // then
        assertEquals(item, strongBox.get())
        assertTrue(strongBox.get() is String)
    }
}
