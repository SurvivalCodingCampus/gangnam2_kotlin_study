package com.survival.kotlinstudy.`08_generic`

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class StrongBoxTest {

    @Test
    fun `keyType이 PADLOCK 일 경우 1,024회 get() 호출 후 data 를 반환한다`() {
        // given (준비)
        val box = StrongBox<String>(KeyType.PADLOCK)
        val data = "비밀스러운 물건"
        box.put(data)
        val lockCount = 1024

        // when (실행)
        repeat(lockCount) {
            box.get()
        }

        // then (검증)
        assertEquals(data, box.get())
    }

    @Test
    fun `keyType이 BUTTON 일 경우 10,000회 get() 호출 후 data 를 반환한다`() {
        // given (준비)
        val box = StrongBox<String>(KeyType.BUTTON)
        val data = "비밀스러운 물건"
        box.put(data)
        val lockCount = 10000

        // when (실행)
        repeat(lockCount) {
            box.get()
        }

        // then (검증)
        assertEquals(data, box.get())
    }

    @Test
    fun `keyType이 DIAL 일 경우 30,000회 get() 호출 후 data 를 반환한다`() {
        // given (준비)
        val box = StrongBox<String>(KeyType.DIAL)
        val data = "비밀스러운 물건"
        box.put(data)
        val lockCount = 30000

        // when (실행)
        repeat(lockCount) {
            box.get()
        }

        // then (검증)
        assertEquals(data, box.get())
    }

    @Test
    fun `keyType이 FINGER 일 경우 1,000,000회 get() 호출 후 data 를 반환한다`() {
        // given (준비)
        val box = StrongBox<String>(KeyType.FINGER)
        val data = "비밀스러운 물건"
        box.put(data)
        val lockCount = 1000000

        // when (실행)
        repeat(lockCount) {
            box.get()
        }

        // then (검증)
        assertEquals(data, box.get())
    }

    @Test
    fun `사용횟수에 도달하기 전에는 null을 리턴한다`() {
        // given (준비)
        val box = StrongBox<Int>(KeyType.PADLOCK)
        val data = 1000
        box.put(data)
        val lockCount = 1023

        // when (실행)
        repeat(lockCount) {
            box.get()
        }

        // then (검증)
        assertNull(box.get())
    }
}