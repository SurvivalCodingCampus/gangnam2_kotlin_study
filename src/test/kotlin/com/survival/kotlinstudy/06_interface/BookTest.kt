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
        val book = Book(name = name, price = price, color = color, isbn = isbn, weight = 0.0)

        // when (실행)

        // then (검증)
        assertEquals(name, book.name)
        assertEquals(price, book.price)
        assertEquals(color, book.color)
        assertEquals(isbn, book.isbn)
    }

    @Test
    fun `Book 인스턴스 생성 후 weight 테스트`() {

        // given (준비)
        val name = "무거운 책"
        val price = 10000
        val color = "Black"
        val isbn = "123123"
        val weight = 11.4
        val book = Book(name = name, price = price, color = color, isbn = isbn,weight = 0.0)

        // when (실행)
        book.weight = weight
        // then (검증)
        assertEquals(name, book.name)
        assertEquals(price, book.price)
        assertEquals(color, book.color)
        assertEquals(isbn, book.isbn)
        assertEquals(weight, book.weight)
    }
}