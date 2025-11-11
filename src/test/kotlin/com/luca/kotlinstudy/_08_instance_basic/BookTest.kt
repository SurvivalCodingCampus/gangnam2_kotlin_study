package com.luca.kotlinstudy._08_instance_basic

import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDateTime

class BookTest {
    private fun dt(y: Int, m: Int, d: Int, h: Int = 0, min: Int = 0, s: Int = 0) =
        LocalDateTime.of(y, m, d, h, min, s)

    @Test
    fun `제목과 출간일이 같을 때 같은 책으로 판단`() {
        val book = Book(
            "Luca", "Luca", dt(2025, 10, 28)
        )
        val book2 = Book(
            "Luca", "Jane", dt(2025, 10, 28)
        )

        assertEquals(book, book2)

    }

    @Test
    fun `출간일 날짜가 다를 때 다른 책으로 판단`() {
        val book = Book(
            "Luca", "Luca", dt(2025, 10, 28)
        )
        val book2 = Book(
            "Luca", "Luca", dt(2025, 10, 27)
        )

        assertNotEquals(book, book2)

    }

    @Test
    fun `sorted()를 했을 때 신상 순서대로 정렬 되는지 확인`() {
        val old = Book("A", "A", dt(2023, 12, 31))
        val mid = Book("B", "B", dt(2024, 1, 1))
        val new = Book("C", "C", dt(2025, 10, 28))
        val sorted = listOf(old, mid, new).sorted() // Comparable 사용

        assertEquals(listOf(new, mid, old), sorted)

    }


    @Test
    fun `깊은 복사가 되고 있는지 확인`() {
        val original = Book("Luca", "Luca", dt(2025, 10, 28, 8, 30))
        val copied = original.deepCopy()
        assertNotSame(original, copied) // 서로 다른 책인지
        assertNotSame(original.publishedDate, copied.publishedDate) // 날짜도 다른지
        assertEquals(original.publishedDate, copied.publishedDate) // 내부 날짜는 같다.
        assertEquals(original, copied)// equals 상 같은 책은 맞다
        assertEquals(original.hashCode(), copied.hashCode()) // hashcode도 같은 책으로 나와야 한다.
    }
}
