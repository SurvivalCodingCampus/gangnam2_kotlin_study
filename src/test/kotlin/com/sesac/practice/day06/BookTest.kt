package com.sesac.practice.day06

import org.junit.Assert.assertEquals
import org.junit.Test

class BookTest {
    @Test
    fun `Book을 생성한다`() {
        // given
        val name = "book"
        val price = 100
        val color = "#112233"
        val isbn = "isbn"

        // when
        val book = Book(name, price, color, isbn)

        // then
        assertEquals(name, book.name)
        assertEquals(price, book.price)
        assertEquals(color, book.color)
        assertEquals(isbn, book.isbn)
        assertEquals(Book.BOOK_WEIGHT, book.weight, 0.0)
    }

    @Test
    fun `Book의 무게를 수정한다`() {
        // given
        val name = "book"
        val price = 100
        val color = "#112233"
        val isbn = "isbn"

        val book = Book(name, price, color, isbn)

        // when
        val weight = 1.1
        book.weight = weight

        // then
        assertEquals(weight, book.weight, 0.0)
    }
}
