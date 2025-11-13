package com.luca.kotlinstudy._09_generic

import org.junit.Assert.*
import org.junit.Test

class StrongBoxTest {

    @Test
    fun `keyType이 PADLOCK 일 때 1,024회 이후 get() 호출 후 data 를 반환한다`() {
        val box = StrongBox<String>(KeyType.PADLOCK)
        val data = "padlock"
        box.put(data)
        val count = 1024

        repeat(count) {
            box.get()
        }

        assertEquals(data, box.get())
    }

    @Test
    fun `keyType이 BUTTON 일 때 10,000회 이후 get() 호출 후 data 를 반환한다`() {
        val box = StrongBox<String>(KeyType.BUTTON)
        val data = "button"
        box.put(data)
        val count = 10000

        repeat(count) {
            box.get()
        }

        assertEquals(data, box.get())
    }

    @Test
    fun `keyType이 DIAL 일 때 30,000회 이후 get() 호출 후 data 를 반환한다`() {
        val box = StrongBox<String>(KeyType.DIAL)
        val data = "dial"
        box.put(data)
        val count = 30000

        repeat(count) {
            box.get()
        }

        assertEquals(data, box.get())
    }

    @Test
    fun `keyType이 FINGER 일 때 1,000,000회 이후 get() 호출 후 data 를 반환한다`() {
        val box = StrongBox<String>(KeyType.FINGER)
        val data = "finger"
        box.put(data)
        val count = 1000000

        repeat(count) {
            box.get()
        }

        assertEquals(data, box.get())
    }

    @Test
    fun `keyType이 PADLOCK 일 때 1,024회 미만은 null을 반환한다`() {
        val box = StrongBox<String>(KeyType.PADLOCK)
        val data = "padlock"
        box.put(data)
        val count = 1023

        repeat(count) {
            box.get()
        }

        assertNull(box.get())
    }

    @Test
    fun `keyType이 BUTTON 일 때 10,000회 미만은 null을 반환한다`() {
        val box = StrongBox<String>(KeyType.BUTTON)
        val data = "button"
        box.put(data)
        val count = 9999

        repeat(count) {
            box.get()
        }

        assertNull(box.get())
    }

    @Test
    fun `keyType이 DIAL 일 때 30,000회 미만은 null을 반환한다`() {
        val box = StrongBox<String>(KeyType.DIAL)
        val data = "dial"
        box.put(data)
        val count = 29999

        repeat(count) {
            box.get()
        }

        assertNull(box.get())
    }

    @Test
    fun `keyType이 FINGER 일 때 1,000,000회 미만은 null을 반환한다`() {
        val box = StrongBox<String>(KeyType.FINGER)
        val data = "finger"
        box.put(data)
        val count = 999999

        repeat(count) {
            box.get()
        }

        assertNull(box.get())
    }

}