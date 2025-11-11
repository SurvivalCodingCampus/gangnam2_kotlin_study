package com.neouul.sesac.`07-instance-manual`

import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDateTime

class BookTest {
    @Test
    fun `Book의 인스턴스가 정상적으로 생성되는 경우`() {
        val title = "하이"
        val author = "나"
        val date = LocalDateTime.of(2025, 11, 11, 0, 0, 0)

        val book = Book(title, author, date)

        assertTrue(book is Book)
        assertEquals(title, book.title)
        assertEquals(author, book.author)
        assertEquals(date, book.publishedDate)
    }

    @Test
    fun `Book 인스턴스의 제목과 출간일이 같아서 같은 책으로 판단되는 경우`() {
        val title = "제목"
        val author = "나"
        val date1 = LocalDateTime.of(2025, 11, 11, 0, 0, 0)
        val date2 = LocalDateTime.of(2025, 11, 11, 1, 0, 0)
        val date3 = LocalDateTime.of(2025, 11, 11, 0, 2, 0)
        val date4 = LocalDateTime.of(2025, 11, 11, 0, 0, 3)

        val book1 = Book(title, author, date1)
        val book2 = Book(title, author, date2)
        val book3 = Book(title, author, date3)
        val book4 = Book(title, author, date4)

        assertEquals(book1, book2)
        assertEquals(book1, book3)
        assertEquals(book1, book4)
    }

    @Test
    fun `Book 인스턴스의 제목이 달라서 같은 책으로 판단되지 않는 경우`() {
        val title1 = "제목1"
        val title2 = "제목2"
        val author = "나"
        val date = LocalDateTime.of(2025, 11, 11, 0, 0, 0)

        val book1 = Book(title1, author, date)
        val book2 = Book(title2, author, date)

        assertNotEquals(book1, book2)
    }

    @Test
    fun `Book 인스턴스의 출간일이 달라서 같은 책으로 판단되지 않는 경우`() {
        val title = "제목"
        val author = "나"
        val date1 = LocalDateTime.of(2025, 11, 11, 0, 0, 0)
        val date2 = LocalDateTime.of(2025, 9, 11, 0, 0, 0)

        val book1 = Book(title, author, date1)
        val book2 = Book(title, author, date2)

        assertNotEquals(book1, book2)
    }
}