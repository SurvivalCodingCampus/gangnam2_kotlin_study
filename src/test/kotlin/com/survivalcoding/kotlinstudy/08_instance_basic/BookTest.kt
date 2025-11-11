package com.survivalcoding.kotlinstudy.`08_instance_basic`

import org.junit.Test
import java.time.LocalDateTime
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotSame
import kotlin.test.assertTrue

class BookTest {
    companion object {
        private const val title = "해리포터"
        private const val title2 = "반지의제왕"
        private const val author1 = "조앤롤링"
        private const val author2 = "헤르미온느"
        private val date = LocalDateTime.of(2025, 11, 11, 10, 0)
        private val previousDate = LocalDateTime.of(2025, 11, 10, 10, 0)
    }

    @Test
    fun `equals 성공 - 제목,날짜가 같은 경우`() {
        //given
        val b1 = Book(title, author1, date)
        val b2 = Book(title, author2, date)

        //then
        assertTrue(b1 == b2)
        assertEquals(b1.hashCode(), b2.hashCode())

    }

    @Test
    fun `equals 실패 - 제목 다를 경우`() {
        //given
        val b1 = Book(title, author1, date)
        val b2 = Book(title2, author2, date)

        //then
        assertFalse(b1 == b2)
    }

    @Test
    fun `equals 실패 - 출간일 다를 경우`() {
        //given
        val b1 = Book(title, author1, date)
        val b2 = Book(title, author2, previousDate)

        //then
        assertFalse(b1 == b2)
    }

    @Test
    fun `hascode 같을시 Set 중복 제거`() {
        //given
        val b1 = Book(title, author1, date)
        val b2 = Book(title, author2, date)

        //when
        val set = mutableSetOf(b1, b2)

        //then
        assertEquals(1, set.size)
    }

    @Test
    fun `날짜 최신순 정렬 - sortedbyDescending`() {
        // given
        val b1 = Book(title, author1, date)
        val b2 = Book(title, author2, previousDate)

        // when
        val list = listOf(b1, b2).sortedByDescending { it.publishedDate.toLocalDate() }

        // then
        assertEquals(b1, list[0]) // 최신 날짜가 먼저 와야 함


    }

    @Test
    fun `deepCopy 성공 - 내용은 같고 주소 다름`() {
        // given
        val original = Book(title, author1, date)

        // when
        val copied = original.deepCopy()

        // then

        assertEquals(original, copied)   // 내용은 동일
        assertNotSame(original, copied)  // 메모리 주소는 다름
    }
}