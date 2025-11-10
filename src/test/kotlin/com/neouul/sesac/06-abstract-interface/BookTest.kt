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

    @Test
    fun `Book이 인터페이스 Thing의 weight를 잘 구현하고 있는가`() {
        // given
        val book = Book("생존코딩", 20000, "blue", "978-89-954321-0-5 03810", 0.8)

        // when: Double형의 weight에게는 getter/setter가 존재한다 = var이다
        book.weight = 1.0

        // then
        assertTrue(book is Thing)
        assertEquals(1.0, book.weight, 1e-9)
    }
}