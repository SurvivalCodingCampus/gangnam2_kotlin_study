package com.sesac.practice.day08

import org.junit.Test
import java.time.LocalDateTime
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNotSame

class BookTest {
    @Test
    fun `책을 생성한다`() {
        // given
        val title = "title"
        val author = "author"
        val publishedDate = LocalDateTime.of(2020, 2, 2, 2, 2)

        // when
        val book = Book(title, author, publishedDate)

        // then
        assertEquals(title, book.title)
        assertEquals(author, book.author)
        assertEquals(publishedDate, book.publishedDate)
    }

    @Test
    fun `책 제목과 출간일이 같으면 같은 책이다`() {
        // given
        val title = "title"
        val author = "author"
        val publishedDate = LocalDateTime.of(2020, 2, 2, 2, 2)

        val originBook = Book(title, author, publishedDate)

        // when
        val anotherAuthor = "another author"
        val book = Book(title, anotherAuthor, publishedDate)

        // then
        assertEquals(book, originBook)
    }

    @Test
    fun `책 제목이 다르면 다른 책이다`() {
        // given
        val title = "title"
        val author = "author"
        val publishedDate = LocalDateTime.of(2020, 2, 2, 2, 2)

        val originBook = Book(title, author, publishedDate)

        // when
        val anotherTitle = "another title"
        val book = Book(anotherTitle, author, publishedDate)

        // then
        assertNotEquals(book, originBook)
    }

    @Test
    fun `책 출간일이 다르면 다른 책이다`() {
        // given
        val title = "title"
        val author = "author"
        val publishedDate = LocalDateTime.of(2020, 2, 2, 2, 2)

        val originBook = Book(title, author, publishedDate)

        // when
        val anotherPublishedDate = LocalDateTime.of(2021, 2, 2, 2, 2)
        val book = Book(title, author, anotherPublishedDate)

        // then
        assertNotEquals(book, originBook)
    }

    @Test
    fun `책 정렬시 신상 순서대로 정렬된다`() {
        // given
        val oldBook = Book("title2", "author2", LocalDateTime.of(2020, 2, 2, 2, 2))
        val middleBook = Book("title", "author", LocalDateTime.of(2021, 2, 2, 2, 2))
        val newBook = Book("title3", "author3", LocalDateTime.of(2022, 2, 2, 2, 2))

        val books = listOf(oldBook, middleBook, newBook)

        // when
        val sortedBooks = books.sorted()

        // then
        assertEquals(
            listOf(newBook, middleBook, oldBook),
            sortedBooks,
        )
    }

    @Test
    fun `책을 깊은 복사한다`() {
        // given
        val title = "title"
        val author = "author"
        val publishedDate = LocalDateTime.of(2020, 2, 2, 2, 2)

        val book = Book(title, author, publishedDate)

        // when
        val copyBook = book.deepCopy()

        // then
        assertNotSame(book, copyBook)
        assertNotSame(book.publishedDate, copyBook.publishedDate)
    }
}
