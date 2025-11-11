package com.survivaalcoding.kotlinstudy.`08_instance_basic`.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.time.LocalDateTime

class BookTest {
    @Test
    fun `Book 객체를 생성할 수 있다`() {
        // given
        val title = "title"
        val author = "author"
        val publishedDate = LocalDateTime.of(2025, 11, 11, 0, 0)

        // when
        val book = Book(title, author, publishedDate)

        // then
        assertThat(book)
            .extracting("title", "author", "publishedDate")
            .contains(title, author, publishedDate)
    }

    @Test
    fun `제목과 출간일(년, 월, 일)이 같으면 같은 책으로 판단한다`() {
        // given
        val title = "title"
        val author = "author"
        val publishedDate1 = LocalDateTime.of(2025, 11, 11, 0, 0)
        val publishedDate2 = LocalDateTime.of(2025, 11, 11, 0, 0)

        // when
        val book1 = Book(title, author, publishedDate1)
        val book2 = Book(title, author, publishedDate2)

        // then
        assertThat(book1).isEqualTo(book2)
        assertThat(book1).isNotSameAs(book2)
    }

    @Test
    fun `제목과 출간일이 같고, 작가가 틀려도 같은 책으로 판단한다`() {
        // given
        val title = "title"
        val author1 = "author1"
        val author2 = "author2"
        val publishedDate1 = LocalDateTime.of(2025, 11, 11, 0, 0)
        val publishedDate2 = LocalDateTime.of(2025, 11, 11, 0, 0)

        // when
        val book1 = Book(title, author1, publishedDate1)
        val book2 = Book(title, author2, publishedDate2)

        // then
        assertThat(book1).isEqualTo(book2)
        assertThat(book1).isNotSameAs(book2)
    }

    @Test
    fun `제목과 출간일(년, 월, 일)이 같고, 출간일의 시간이 틀려도 같은 책으로 판단한다`() {
        // given
        val title = "title"
        val author = "author"
        val publishedDate1 = LocalDateTime.of(2025, 11, 11, 0, 0)
        val publishedDate2 = LocalDateTime.of(2025, 11, 11, 1, 0)

        // when
        val book1 = Book(title, author, publishedDate1)
        val book2 = Book(title, author, publishedDate2)

        // then
        assertThat(book1).isEqualTo(book2)
        assertThat(book1).isNotSameAs(book2)
    }

    @Test
    fun `제목과 출간일(년, 월, 일)이 같고, 출간일의 분이 틀려도 같은 책으로 판단한다`() {
        // given
        val title = "title"
        val author = "author"
        val publishedDate1 = LocalDateTime.of(2025, 11, 11, 0, 0)
        val publishedDate2 = LocalDateTime.of(2025, 11, 11, 0, 1)

        // when
        val book1 = Book(title, author, publishedDate1)
        val book2 = Book(title, author, publishedDate2)

        // then
        assertThat(book1).isEqualTo(book2)
        assertThat(book1).isNotSameAs(book2)
    }

    @Test
    fun `제목과 출간일(년, 월, 일)이 같고, 출간일의 초가 틀려도 같은 책으로 판단한다`() {
        // given
        val title = "title"
        val author = "author"
        val publishedDate1 = LocalDateTime.of(2025, 11, 11, 0, 0, 0)
        val publishedDate2 = LocalDateTime.of(2025, 11, 11, 0, 0, 1)

        // when
        val book1 = Book(title, author, publishedDate1)
        val book2 = Book(title, author, publishedDate2)

        // then
        assertThat(book1).isEqualTo(book2)
        assertThat(book1).isNotSameAs(book2)
    }

    @Test
    fun `제목은 틀리고, 출간일이 같아도 다른 책으로 판단한다`() {
        // given
        val title1 = "title1"
        val title2 = "title2"
        val author = "author"
        val publishedDate = LocalDateTime.of(2025, 11, 11, 0, 0)

        // when
        val book1 = Book(title1, author, publishedDate)
        val book2 = Book(title2, author, publishedDate)

        // then
        assertThat(book1).isNotEqualTo(book2)
        assertThat(book1).isNotSameAs(book2)
    }

    @Test
    fun `제목은 같고, 출간일(월, 일)은 같고, 출간일의 년이 틀리면 다른 책으로 판단한다`() {
        // given
        val title = "title"
        val author = "author"
        val publishedDate1 = LocalDateTime.of(2025, 11, 11, 0, 0)
        val publishedDate2 = LocalDateTime.of(2024, 11, 11, 0, 0)

        // when
        val book1 = Book(title, author, publishedDate1)
        val book2 = Book(title, author, publishedDate2)

        // then
        assertThat(book1).isNotEqualTo(book2)
        assertThat(book1).isNotSameAs(book2)
    }

    @Test
    fun `제목은 같고, 출간일(년, 일)은 같고, 출간일의 월이 틀리면 다른 책으로 판단한다`() {
        // given
        val title = "title"
        val author = "author"
        val publishedDate1 = LocalDateTime.of(2025, 11, 11, 0, 0)
        val publishedDate2 = LocalDateTime.of(2025, 10, 11, 0, 0)

        // when
        val book1 = Book(title, author, publishedDate1)
        val book2 = Book(title, author, publishedDate2)

        // then
        assertThat(book1).isNotEqualTo(book2)
        assertThat(book1).isNotSameAs(book2)
    }

    @Test
    fun `제목은 같고, 출간일(년, 월)은 같고, 출간일의 일이 틀리면 다른 책으로 판단한다`() {
        // given
        val title = "title"
        val author = "author"
        val publishedDate1 = LocalDateTime.of(2025, 11, 11, 0, 0)
        val publishedDate2 = LocalDateTime.of(2025, 11, 12, 0, 0)

        // when
        val book1 = Book(title, author, publishedDate1)
        val book2 = Book(title, author, publishedDate2)

        // then
        assertThat(book1).isNotEqualTo(book2)
        assertThat(book1).isNotSameAs(book2)
    }

    @Test
    fun `정렬 시 출간일이 신상 순서대로 정렬이 되어야 한다`() {
        // given
        val title1 = "title1"
        val title2 = "title2"
        val title3 = "title3"
        val title4 = "title4"
        val title5 = "title5"
        val author1 = "author1"
        val author2 = "author2"
        val author3 = "author3"
        val author4 = "author4"
        val author5 = "author5"
        val publishedDate1 = LocalDateTime.of(2025, 1, 1, 0, 0)
        val publishedDate2 = LocalDateTime.of(2025, 11, 5, 0, 0)
        val publishedDate3 = LocalDateTime.of(2025, 11, 1, 0, 0)
        val publishedDate4 = LocalDateTime.of(2025, 5, 2, 0, 0)
        val publishedDate5 = LocalDateTime.of(2025, 3, 7, 0, 0)

        val book1 = Book(title1, author1, publishedDate1)
        val book2 = Book(title2, author2, publishedDate2)
        val book3 = Book(title3, author3, publishedDate3)
        val book4 = Book(title4, author4, publishedDate4)
        val book5 = Book(title5, author5, publishedDate5)

        // when
        val books = listOf(book1, book2, book3, book4, book5)
        val sortedBooks = books.sorted()

        // then
        assertThat(sortedBooks).hasSize(5)
            .containsExactly(book2, book3, book4, book5, book1)
    }

    @Test
    fun `Book 객체의 깊은 복사를 제공한다`() {
        // given
        val title = "title"
        val author = "author"
        val publishedDate = LocalDateTime.of(2025, 11, 11, 0, 0)

        val book = Book(title, author, publishedDate)

        // when
        val deepCopyBook = book.deepCopy()

        // then
        assertThat(book).isEqualTo(deepCopyBook)
        assertThat(book).isNotSameAs(deepCopyBook)
        assertThat(book.publishedDate).isEqualTo(deepCopyBook.publishedDate)
        assertThat(book.publishedDate).isNotSameAs(deepCopyBook.publishedDate)
    }
}