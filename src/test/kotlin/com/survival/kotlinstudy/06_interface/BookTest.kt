package com.survival.kotlinstudy.`06_interface`

import org.junit.Test
import kotlin.test.assertEquals

class BookTest {

    @Test
    fun `Book 인스턴스 생성 테스트`() {

        // given (준비)
        val name = "책"
        val price = 10000
        val color = "Black"
        val isbn = "123123"
        val book = Book(name = name, price = price, color = color, isbn = isbn)

        // when (실행)

        // then (검증)
        assertEquals(name, book.name)
        assertEquals(price, book.price)
        assertEquals(color, book.color)
        assertEquals(isbn, book.isbn)
    }
}