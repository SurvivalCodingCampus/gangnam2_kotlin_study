package com.hhp227.kotlinstudy.`08_instance_basic`

import org.junit.Test
import java.time.LocalDateTime
import kotlin.collections.sorted
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BookTest {
    @Test
    fun `제목과 출간일(2024-01-01)이 같으면 같은 책으로 판단한다`() {
        val book1 = Book(title = "생존코딩", "오준석", LocalDateTime.of(2024, 1, 1, 0, 0))
        val book2 = Book(title = "생존코딩", "홍길동", LocalDateTime.of(2024, 1, 1, 0, 0))
        val book3 = Book(title = "죽음코딩", "김덕배", LocalDateTime.of(2012, 1, 1, 1, 1))
        val book4 = Book(title = "생존코딩", "김철수", LocalDateTime.of(2024, 1, 1, 1, 0))

        assertTrue(book1 == book2)
        assertFalse(book1 == book3)
        assertFalse(book1 == book4)
    }

    @Test
    fun `Book 인스턴스를 담고 있는 컬렉션에 대해 sorted() 를 수행하면 출간일이 신상 순서대로 정렬되어야 함 `() {
        val bookList: ArrayList<Book> = arrayListOf(
            Book(title = "Effective Java", "noname", LocalDateTime.of(2005, 1, 1, 0, 0)),
            Book(title = "춘향전", "전래동화", LocalDateTime.of(1603, 1, 1, 0, 0)),
            Book(title = "심청전", "전래동화", LocalDateTime.of(1564, 2, 1, 0, 0)),
            Book(title = "Effective Kotlin", "bryan", LocalDateTime.of(2014, 1, 1, 0, 0)),
            Book(title = "이솝우화", "이솝", LocalDateTime.of(1792, 1, 1, 0, 0)),
            Book(title = "안네의 일기", "김안네", LocalDateTime.of(1921, 1, 1, 0, 0))
        )

        val sortedBooks = bookList.sorted()
        val bookTitleList = sortedBooks.map(Book::title)

        assertEquals(listOf("심청전", "춘향전", "이솝우화", "안네의 일기", "Effective Java", "Effective Kotlin"), bookTitleList)
    }

    @Test
    fun `깊은 복사를 제공한다`() {
        val book1 = Book("생존코딩", "오준석", LocalDateTime.now())
        val book2 = Book(book1.title, book1.author, book1.publishedDate)
        val book3 = book1.deepCopy()

        assertTrue(book1 == book2)
        assertFalse(book1 === book2)
        assertTrue(book1.publishedDate == book2.publishedDate)
        assertTrue(book1 == book3)
        assertFalse(book1 === book3)
        assertTrue(book1.publishedDate == book3.publishedDate)
    }
}