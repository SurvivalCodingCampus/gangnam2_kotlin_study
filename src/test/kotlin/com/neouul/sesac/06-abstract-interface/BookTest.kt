package com.neouul.sesac.`06-abstract-interface`

import org.junit.Assert.*
import org.junit.Test

class BookTest {
    @Test
    fun `Book의 인스턴스가 추상클래스와 인스턴스를 잘 구현하고 있는가`() {
        // given
        val book = Book("생존코딩", 20000, "blue", "978-89-954321-0-5 03810", 0.8)

        // then
        assertEquals("생존코딩", book.name)
        assertEquals(20000, book.price)
        assertEquals("blue", book.color)
        assertEquals("978-89-954321-0-5 03810", book.isbn)
        assertEquals(0.8, book.weight, 1e-9)

        assertTrue(book is TangibleAsset)
        assertTrue(book is Thing)
        assertTrue(book is Asset)
    }
}