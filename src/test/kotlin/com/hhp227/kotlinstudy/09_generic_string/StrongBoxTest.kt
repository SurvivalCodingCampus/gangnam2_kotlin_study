package com.hhp227.kotlinstudy.`09_generic_string`

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertIs
import kotlin.test.assertTrue

class StrongBoxTest {
    @Test
    fun `쿠팡에서 이 금고를 주문할 때 키 타입을 정해서 주문을 한다`() {
        val strongBox1 = StrongBox<String>(StrongBox.KeyType.Padlock)
        val strongBox2 = StrongBox<String>(StrongBox.KeyType.Dial)
        val strongBox3 = StrongBox<String>(StrongBox.KeyType.Button)
        val strongBox4 = StrongBox<String>(StrongBox.KeyType.Finger)

        assertIs<StrongBox.KeyType>(strongBox1.type)
        assertTrue(strongBox1.type == StrongBox.KeyType.Padlock)
        assertIs<StrongBox.KeyType>(strongBox2.type)
        assertTrue(strongBox2.type == StrongBox.KeyType.Dial)
        assertIs<StrongBox.KeyType>(strongBox3.type)
        assertTrue(strongBox3.type == StrongBox.KeyType.Button)
        assertIs<StrongBox.KeyType>(strongBox4.type)
        assertTrue(strongBox4.type == StrongBox.KeyType.Finger)
    }

    @Test
    fun `금고에 넣고 싶은 것을 넣을 수 있다`() {
        val strongBox1 = StrongBox<Int>(StrongBox.KeyType.Padlock)
        val strongBox2 = StrongBox<Any>(StrongBox.KeyType.Padlock)
        val strongBox3 = StrongBox<String>(StrongBox.KeyType.Padlock)

        strongBox1.put(1)
        strongBox1.put(2)

        strongBox2.put(1)
        strongBox2.put("Test")

        strongBox3.put("Hello")

        assertIs<Int?>(strongBox1.get())
        assertIs<Any?>(strongBox2.get())
        assertIs<String?>(strongBox3.get())
    }

    @Test
    fun `키 타입에 따라 정해진 횟수만큼은 열리지 않는다, 횟수에 도달하면 잠금이 해제되어 열린다`() {
        val strongBox1 = StrongBox<Int>(StrongBox.KeyType.Button)
        var padlockCount = 10_000

        strongBox1.put(1)

        assertFalse(strongBox1.get() == 1)
        assertTrue(strongBox1.get() == null)

        padlockCount -= 2

        while (padlockCount > 1) {
            assertTrue(strongBox1.get() == null)
            padlockCount--
        }

        assertIs<Int>(strongBox1.get())
        assertTrue(strongBox1.get() == 1)
    }
}