package com.survivalcoding.kotlinstudy.`08_instance_basic`.practice

import org.junit.jupiter.api.Test
import java.time.LocalDate
import kotlin.test.assertEquals

class BookTest {
    @Test
    fun `제목과 출간일이 같으면 같은 책으로 판단하는지 확인`() {
        val book1 = Book("소나기", "황순원", PublishedDate(LocalDate.of(1953, 5, 11)))
        val book2 = Book("소나기", "황순투", PublishedDate(LocalDate.of(1953, 5, 11)))

        assertEquals((book1.equals(book2)), true)
        assertEquals((book1 == book2), true)
        assertEquals((book1 === book2), false)
    }

    @Test
    fun `sorted()를 수행하면 출간일이 신상 순서대로 정렬하는지 확인`() {
        val books = listOf(
            Book("날개", "이상", PublishedDate(LocalDate.of(1936, 9, 3))),
            Book("운수 좋은 날", "현진건", PublishedDate(LocalDate.of(1924, 6, 11))),
            Book("무정", "이광수", PublishedDate(LocalDate.of(1917, 1, 1)))
        )

        val results = books.sortedBy { it.publishedDate.publishedLocalDate }

        println(results)
    }

    @Test
    fun `깊은 복사를 하는지 확인`() {
        val book1 = Book("소나기", "황순원", PublishedDate(LocalDate.of(1953, 5, 11)))
        val book2 = book1.deepCopy()

        assertEquals((book1 === book2), false)
    }
}