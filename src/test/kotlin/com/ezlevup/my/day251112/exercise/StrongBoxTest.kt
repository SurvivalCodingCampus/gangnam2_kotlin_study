package com.ezlevup.my.day251112.exercise

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNull

class StrongBoxTest {
    @Test
    fun `금고 Int 타입 담기`() {
        // given
        val box = StrongBox<Int>(KeyType.PADLOCK)

        // when // then
        val data: Int = 100
        box.put(data)
        val result: Int? = box.get()

        // then
        assertNull(result)
    }

    @Test
    fun `금고 String 타입 담기`() {
        // given
        val box = StrongBox<String>(KeyType.PADLOCK)

        // when // then
        val data: String = "lee"
        box.put(data)
        val result: String? = box.get()

        // then
        assertNull(result)
    }


    @Test
    fun `금고 사용자 데이터 타입 담기`() {
        // given
        data class Lee(val hp: Int) {}

        val box = StrongBox<Lee>(KeyType.PADLOCK)

        // when
        val data: Lee = Lee(100)
        box.put(data)
        val result: Lee? = box.get()

        // then
        assertNull(result)
    }

    @Test
    fun `금고 key 열기 성공`() {
        KeyType.entries.forEach {
            // println(it.name)

            // given
            val keyType: KeyType = it
            val box = StrongBox<Int>(keyType)

            // when
            val data: Int = 100
            box.put(data)

            val repeatCount: Int = KeyData.MAX_ATTEMPTS[keyType] ?: 0

            var i: Int? = 0
            repeat(repeatCount) {
                i = box.get()
            }
            val result: Int = i ?: 0
            val count: Int = box.attemptCount

            // then
            assertEquals(count, repeatCount)
            assertEquals(data, result)
        }
    }


    @Test
    fun `금고 key 열기 실패`() {
        KeyType.entries.forEach {
            // given
            val keyType: KeyType = it
            val box = StrongBox<Int>(keyType)

            // when
            val data: Int = 100
            box.put(data)

            var repeatCount: Int = KeyData.MAX_ATTEMPTS[keyType] ?: 0
            repeatCount -= 1

            var i: Int? = 0
            repeat(repeatCount) {
                i = box.get()
            }
            val result: Int = i ?: 0
            val count: Int = box.attemptCount

            assertEquals(count, repeatCount)
            assertNotEquals(data, result)
        }
    }

}


