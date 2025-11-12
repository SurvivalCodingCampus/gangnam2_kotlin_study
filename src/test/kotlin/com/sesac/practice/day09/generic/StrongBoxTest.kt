package com.sesac.practice.day09.generic

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class StrongBoxTest {
    @Test
    fun `금고를 생성한다`() {
        // given
        val keyType = KeyType.PADLOCK
        val item = 1
        val tryCount = keyType.tryLimit

        // when
        val strongBox: StrongBox<Int> = StrongBox(keyType, item, tryCount)

        // then
        assertEquals(item, strongBox.get())
        assertTrue(strongBox.get() is Int)
    }

    @Test
    fun `금고에 아이템을 넣는다`() {
        // given
        val keyType = KeyType.PADLOCK
        val item = "item"
        val tryCount = keyType.tryLimit
        val strongBox: StrongBox<String> = StrongBox(keyType, item, tryCount)

        // when
        val changeItem = "change item"
        strongBox.put(changeItem)

        // then
        assertEquals(changeItem, strongBox.get())
        assertTrue(strongBox.get() is String)
    }

    @Test
    fun `금고에서 열쇠의 사용횟수에 도달하면 잠금이 해제되어 열린다`() {
        // given
        val keyType = KeyType.PADLOCK
        val item = "item"
        val tryCount = keyType.tryLimit - 1
        val strongBox: StrongBox<String> = StrongBox(keyType, item, tryCount)

        // when
        val get = strongBox.get()

        // then
        assertEquals(item, get)
    }

    @Test
    fun `금고에서 열쇠의 사용횟수 도달하기 전에는 null을 리턴한다`() {
        // given
        val keyType = KeyType.PADLOCK
        val item = "item"
        val tryCount = keyType.tryLimit - 2
        val strongBox = StrongBox(keyType, item, tryCount)

        // when
        val get = strongBox.get()

        // then
        assertNull(get)
    }
}
