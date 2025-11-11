package com.survival.kotlinstudy.`07_instance_basic`

import org.junit.Test
import java.time.LocalDateTime
import kotlin.test.assertEquals

class BookTest {

    @Test
    fun `Book 인스턴스 생성 테스트`() {

        // given (준비)
        val title = "책"
        val author = "저자"
        val publishedDate = LocalDateTime.now()

        val book = Book(title = title, author = author, publishedDate = publishedDate)

        // when (실행)


        // then (검증)

        assertEquals(title, book.title)
        assertEquals(author, book.author)
        assertEquals(publishedDate, book.publishedDate)

    }

    @Test
    fun `제목과 출간일이 같으면 같은 책으로 판단한다`() {

        // given (준비)
        val title1 = "책"
        val author1 = "저자1"
        val publishedDate1 = LocalDateTime.now()
        val title2 = "책"
        val author2 = "저자2"
        val publishedDate2 = LocalDateTime.now()

        val book1 = Book(title = title1, author = author1, publishedDate = publishedDate1)
        val book2 = Book(title = title2, author = author2, publishedDate = publishedDate2)
        // when (실행)

        // then (검증)
        assertEquals(true, book1 == book2)
    }

    @Test
    fun `제목이 다른 경우 테스트`() {

        // given (준비)
        val title1 = "책"
        val author1 = "저자1"
        val publishedDate1 = LocalDateTime.now()
        val title2 = "북"
        val author2 = "저자1"
        val publishedDate2 = LocalDateTime.now()

        val book1 = Book(title = title1, author = author1, publishedDate = publishedDate1)
        val book2 = Book(title = title2, author = author2, publishedDate = publishedDate2)
        // when (실행)

        // then (검증)
        assertEquals(false, book1 == book2)
    }

    @Test
    fun `출간일이 다른 경우 테스트`() {

        // given (준비)
        val title1 = "책"
        val author1 = "저자1"
        val publishedDate1 = LocalDateTime.of(2024, 1, 1, 10, 0)
        val title2 = "책"
        val author2 = "저자1"
        val publishedDate2 = LocalDateTime.of(2024, 1, 2, 10, 0)

        val book1 = Book(title = title1, author = author1, publishedDate = publishedDate1)
        val book2 = Book(title = title2, author = author2, publishedDate = publishedDate2)
        // when (실행)

        // then (검증)
        assertEquals(false, book1 == book2)
    }

    @Test
    fun `제목과 출간일이 다른 경우 테스트`() {

        // given (준비)
        val title1 = "책"
        val author1 = "저자1"
        val publishedDate1 = LocalDateTime.of(2024, 1, 1, 10, 0)
        val title2 = "북"
        val author2 = "저자1"
        val publishedDate2 = LocalDateTime.of(2024, 1, 2, 10, 0)

        val book1 = Book(title = title1, author = author1, publishedDate = publishedDate1)
        val book2 = Book(title = title2, author = author2, publishedDate = publishedDate2)
        // when (실행)

        // then (검증)
        assertEquals(false, book1 == book2)
    }

    @Test
    fun `Book 인스턴스를 담고 있는 컬렉션에 대해 sorted() 수행 시 출간일이 신상 순서대로 정렬되는지 테스트`() {
        // given (준비)
        val first = LocalDateTime.of(2025, 1, 1, 12, 0)
        val second = LocalDateTime.of(2024, 1, 1, 12, 0)
        val third = LocalDateTime.of(2023, 1, 1, 12, 0)

        val book1 = Book(title = "책1", author = "저자1", publishedDate = second)
        val book2 = Book(title = "책2", author = "저자2", publishedDate = first)
        val book3 = Book(title = "책3", author = "저자3", publishedDate = third)

        val bookList = listOf(book1, book2, book3)

        val expectedList = listOf(book2, book1, book3)

        // when (실행)
        val sortedList = bookList.sorted()
        // then (검증)
        assertEquals(expectedList, sortedList)

    }
}