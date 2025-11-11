package com.ezlevup.my.day251111.exercise

import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDateTime

class BookTest {
    @Test
    fun `Book 생성자`() {
        // given
        val title: String = "A"
        val author: String = "a"
        val publishedDate: LocalDateTime = LocalDateTime.of(2025, 11, 1, 0, 0)
        val book = Book(title = title, author = author, publishedDate = publishedDate)

        // then
        assertEquals(title, book.title)
        assertEquals(author, book.author)
        assertEquals(publishedDate, book.publishedDate)
    }

    @Test
    fun `Book equals 확인`() {
        // given
        val title: String = "A"
        val author: String = "a"
        val publishedDate: LocalDateTime = LocalDateTime.of(2025, 11, 1, 0, 0)
        val book1 = Book(title = title, author = author, publishedDate = publishedDate)
        val book2 = Book(title = title, author = author, publishedDate = publishedDate)

        // when
        val isEqual: Boolean = (book1 == book2)

        // then
        assertTrue(isEqual)
    }

    @Test
    fun `Book equals 실패 확인`() {
        // given
        val title: String = "A"
        val author: String = "a"
        val publishedDate: LocalDateTime = LocalDateTime.of(2025, 11, 1, 0, 0)
        val book1 = Book(title = title, author = author, publishedDate = publishedDate)

        val title2: String = "B"
        val book2 = Book(title = title2, author = author, publishedDate = publishedDate)

        // when
        val isEqual: Boolean = (book1 == book2)

        // then
        assertFalse(isEqual)
    }

    @Test
    fun `Book compareTo 는 최신 날짜가 더 작은 값을 반환`() {
        // Given
        val olderBook = Book("A", "a", LocalDateTime.of(2025, 10, 1, 0, 0))
        val newerBook = Book("B", "b", LocalDateTime.of(2025, 11, 1, 0, 0))

        // When & Then
        assertTrue(newerBook.compareTo(olderBook) < 0) // 최신 책이 더 작음
        assertTrue(olderBook.compareTo(newerBook) > 0) // 오래된 책이 더 큼
    }

    @Test
    fun `Book compareTo는 같은 날짜일 때 0을 반환`() {
        // Given
        val book1 = Book("A", "a", LocalDateTime.of(2025, 11, 11, 11, 11))
        val book2 = Book("B", "b", LocalDateTime.of(2025, 11, 11, 11, 11))

        // When & Then
        assertEquals(0, book1.compareTo(book2))
    }

    @Test
    fun `Book sorted() 는 최신 날짜 순으로 정렬`() {
        // Given
        val books = mutableListOf(
            Book("A", "a", LocalDateTime.of(2025, 11, 1, 0, 0)),
            Book("B", "b", LocalDateTime.of(2025, 10, 1, 0, 0)),
            Book("C", "c", LocalDateTime.of(2025, 12, 1, 0, 0))
        )

        // When
        val sortedBooks = books.sorted()

        // Then
        assertEquals("C", sortedBooks[0].title) // 12월
        assertEquals("A", sortedBooks[1].title) // 11월
        assertEquals("B", sortedBooks[2].title) // 10월
    }

    @Test
    fun `Book 비교 연산자 확인`() {
        // Given
        val book1 = Book("title1", "author1", LocalDateTime.of(2025, 11, 11, 0, 0))
        val book2 = Book("title2", "author2", LocalDateTime.of(2025, 12, 31, 0, 0))

        // When & Then
        assertTrue(book2 < book1) // 내림차순
    }

    @Test
    fun `Book deepCopy 확인`() {
        // Given
        val book1 = Book("title1", "author1", LocalDateTime.of(2025, 11, 11, 0, 0))
        val book2 = book1.deepCopy()

        // When & Then
        assertFalse(book1 === book2)
    }

}
