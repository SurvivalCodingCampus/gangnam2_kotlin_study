package com.survivaalcoding.kotlinstudy.`06_abstract_interface`.example

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class BookTest {
    @Test
    fun `Book 객체를 생성할 수 있다`() {
        // given
        val weight = 2.0
        val name = "book1"
        val price = 500
        val stock = 30
        val color = "black"
        val isbn = "001"

        // when
        val book = Book(weight, name, price, stock, color, isbn)

        // then
        assertThat(book.weight).isEqualTo(weight)
        assertThat(book.name).isEqualTo(name)
        assertThat(book.price).isEqualTo(price)
        assertThat(book.stock).isEqualTo(stock)
        assertThat(book.color).isEqualTo(color)
        assertThat(book.isbn).isEqualTo(isbn)
    }

    @Test
    fun `책을 대여할 수 있다`() {
        // given
        val weight = 2.0
        val name = "book1"
        val price = 500
        val stock = 30
        val color = "black"
        val isbn = "001"
        val rentalQuantity = 5

        val book = Book(weight, name, price, stock, color, isbn)

        // when
        val result = book.rental(rentalQuantity)

        // then
        assertThat(result).isTrue
        assertThat(book.stock).isEqualTo(stock - rentalQuantity)
    }

    @Test
    fun `재고를 차감할 수 있다`() {
        // given
        val weight = 2.0
        val name = "book1"
        val price = 500
        val stock = 5
        val color = "black"
        val isbn = "001"
        val quantity = 2

        val book = Book(weight, name, price, stock, color, isbn)

        // when
        book.decreaseStock(quantity)

        // then
        assertThat(book.stock).isEqualTo(stock - quantity)
    }

    @Test
    fun `재고 개수보다 많이 차감하면 예외가 발생한다`() {
        // given
        val weight = 2.0
        val name = "book1"
        val price = 500
        val stock = 5
        val color = "black"
        val isbn = "001"
        val quantity = 10

        val book = Book(weight, name, price, stock, color, isbn)

        // when
        // then
        assertThatThrownBy { book.decreaseStock(quantity) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `재고가 부족해 책을 대여할 수 없다`() {
        // given
        val weight = 2.0
        val name = "book1"
        val price = 500
        val stock = 3
        val color = "black"
        val isbn = "001"
        val rentalQuantity = 5

        val book = Book(weight, name, price, stock, color, isbn)

        // when
        val result = book.rental(rentalQuantity)

        // then
        assertThat(result).isFalse
        assertThat(book.stock).isEqualTo(stock)
    }

    @Test
    fun `책 정보를 확인할 수 있다`() {
        // given
        val weight = 2.0
        val name = "book1"
        val price = 500
        val stock = 3
        val color = "black"
        val isbn = "001"

        val bookInfo = """
            명칭: $name
            무게: $weight
            가격: $price
            재고: $stock
            색상: $color
            상품번호: $isbn
        """.trimIndent()

        val book = Book(weight, name, price, stock, color, isbn)

        // when
        val result = book.getInfo()

        // then
        assertThat(result).isEqualTo(bookInfo)
    }
}