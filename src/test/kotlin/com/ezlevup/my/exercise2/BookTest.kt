package com.ezlevup.my.exercise2

import org.junit.Assert.assertEquals
import org.junit.Test

class BookTest {
    @Test
    fun `책 생성자`() {
        // given
        val name = "수학의 정석"
        val price = 23000
        val color = "red"
        val isbn = "12345"
        val weight = 12.4
        val book = Book(name = name, price = price, color = color, isbn = isbn, weight = weight)

        // then
        assertEquals(name, book.name)
        assertEquals(price, book.price)
        assertEquals(color, book.color)
        assertEquals(isbn, book.isbn)
        assertEquals(weight, book.weight, 0.001)
    }
}