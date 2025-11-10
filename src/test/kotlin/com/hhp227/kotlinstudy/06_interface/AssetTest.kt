package com.hhp227.kotlinstudy.`06_interface`

import junit.framework.TestCase.assertTrue
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class AssetTest {
    @Test
    fun `Book 정보가 올바르게 설정되어야 한다`() {
        val book = Book(
            name = "이펙티브 코틀린",
            price = 35000,
            color = "Blue",
            isbn = "1234512345",
            weight = 1.2
        )

        assertEquals("이펙티브 코틀린", book.name)
        assertEquals(35000, book.price)
        assertEquals("Blue", book.color)
        assertEquals(1.2, book.weight)
        assertEquals("1234512345", book.isbn)
    }

    @Test
    fun `Computer 정보가 올바르게 설정되어야 한다`() {
        val computer = Computer(
            name = "MacBook Pro",
            price = 2300000,
            color = "Rose Gold",
            makerName = "Apple",
            weight = 2.5
        )

        assertEquals("MacBook Pro", computer.name)
        assertEquals(2300000, computer.price)
        assertEquals("Rose Gold", computer.color)
        assertEquals(2.5, computer.weight)
        assertEquals("Apple", computer.makerName)
    }

    @Test
    fun `Patent 정보가 올바르게 설정되어야 한다`() {
        val patent = Patent(
            name = "AI 알고리즘",
            price = 1000000,
            color = "Red",
            patentNumber = "1234567890"
        )

        assertEquals("AI 알고리즘", patent.name)
        assertEquals(1000000, patent.price)
        assertEquals("Red", patent.color)
        assertEquals("1234567890", patent.patentNumber)
    }

    @Test
    fun `TangibleAsset은 Thing 인터페이스를 구현해야 한다`() {
        val book = Book(
            name = "이펙티브 코틀린",
            price = 30000,
            color = "Blue",
            isbn = "1234512345",
            weight = 1.2
        )
        val computer = Computer(
            name = "MacBook Pro",
            price = 2000000,
            color = "Black",
            makerName = "Apple",
            weight = 2.5
        )
        val patent = Patent(
            name = "AI 알고리즘",
            price = 1000000,
            color = "Red",
            patentNumber = "1234567890"
        )

        assertTrue(book is Thing)
        assertTrue(computer is Thing)
        assertTrue(patent !is Thing)
    }

    @Test
    fun `Thing의 weight 프로퍼티는 변경 가능해야 한다`() {
        val computer = Computer(
            name = "MacBook Pro",
            price = 2000000,
            color = "Silver",
            makerName = "Apple",
            weight = 2.5
        )
        val initialWeight = computer.weight
        computer.weight = 3.0

        assertNotEquals(initialWeight, computer.weight)
        assertEquals(3.0, computer.weight)
    }
}
