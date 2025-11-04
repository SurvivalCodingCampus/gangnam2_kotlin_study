package com.survivalcoding.kotlinstudy.`06_abstract_class_interface`

import kotlin.test.Test
import kotlin.test.assertEquals

class AssetTest {

    companion object {
        private const val BOOK_NAME = "Book"
        private const val BOOK_PRICE = 28000
        private const val BOOK_COLOR = "White"
        private const val BOOK_ISBN = "12345"
        private const val BOOK_WEIGHT = 1.5
    }

    @Test
    fun `Asset 공통 속성 - name, price 생성 확인`() {
        val book = Book(BOOK_NAME, BOOK_PRICE, BOOK_COLOR, BOOK_ISBN, BOOK_WEIGHT)

        assertEquals(BOOK_NAME, book.name)
        assertEquals(BOOK_PRICE, book.price)
    }
}


class ThingTest {

    companion object {
        private const val BOOK_WEIGHT = 1.5
        private const val COMPUTER_WEIGHT = 1.5
        private const val BOOK_NAME = "Effective Kotlin"
        private const val COMPUTER_NAME = "MacBook Air M4"
    }

    @Test
    fun `Thing 인터페이스 구현`() {
        val book = Book(BOOK_NAME, 20000, "Red", "12345", BOOK_WEIGHT)
        val computer = Computer(COMPUTER_NAME, 1500000, "Silver", "Apple", COMPUTER_WEIGHT)

        val thing1: Thing = book
        val thing2: Thing = computer

        assertEquals(BOOK_WEIGHT, thing1.weight)
        assertEquals(COMPUTER_WEIGHT, thing2.weight)
    }
}

class TangibleAssetTest {

    companion object {
        private const val BOOK_NAME = "Effective Kotlin"
        private const val BOOK_PRICE = 30000
        private const val BOOK_COLOR = "Blue"
        private const val BOOK_ISBN = "12345"
        private const val BOOK_WEIGHT = 1.2

        private const val COMPUTER_NAME = "MacBook Air M4"
        private const val COMPUTER_PRICE = 1500000
        private const val COMPUTER_COLOR = "Silver"
        private const val COMPUTER_MAKER = "Apple"
        private const val COMPUTER_WEIGHT = 1.25
    }

    @Test
    fun `TangibleAsset 상속 - Book`() {
        val book = Book(
            name = BOOK_NAME,
            price = BOOK_PRICE,
            color = BOOK_COLOR,
            isbn = BOOK_ISBN,
            weight = BOOK_WEIGHT
        )

        assertEquals(BOOK_NAME, book.name)
        assertEquals(BOOK_PRICE, book.price)
        assertEquals(BOOK_COLOR, book.color)
        assertEquals(BOOK_ISBN, book.isbn)
        assertEquals(BOOK_WEIGHT, book.weight, 0.0)
    }

    @Test
    fun `TangibleAsset 상속 - Computer`() {
        val computer = Computer(
            name = COMPUTER_NAME,
            price = COMPUTER_PRICE,
            color = COMPUTER_COLOR,
            makerName = COMPUTER_MAKER,
            weight = COMPUTER_WEIGHT
        )

        assertEquals(COMPUTER_NAME, computer.name)
        assertEquals(COMPUTER_PRICE, computer.price)
        assertEquals(COMPUTER_COLOR, computer.color)
        assertEquals(COMPUTER_MAKER, computer.makerName)
        assertEquals(COMPUTER_WEIGHT, computer.weight, 0.0)
    }
}

