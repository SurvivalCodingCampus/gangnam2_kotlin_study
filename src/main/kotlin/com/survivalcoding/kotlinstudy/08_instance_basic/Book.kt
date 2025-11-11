package com.survivalcoding.kotlinstudy.`08_instance_basic`

import java.time.LocalDateTime

class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = LocalDateTime.now()
) {
    // equals 재정의
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        // 제목 비교
        if (title != other.title) return false
        // 날짜만 추출해서 비교
        if (publishedDate.toLocalDate() != other.publishedDate.toLocalDate()) return false

        return true
    }

    // hashcode 재정의
    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + publishedDate.toLocalDate().hashCode()
        return result
    }

    // print 해서 보기 위해서 재정의
    override fun toString(): String {
        return "Book(title='$title', author='$author', publishedDate=${publishedDate})"
    }

    // 객체 주소를 새로 생성하는 DeepCopy
    fun deepCopy() = Book(title, author, publishedDate)

}

fun main() {
    // 동일한지 비교
    val book1 = Book("해리포터", "롤링")
    val book2 = Book("해리포터", "헤르미온느")
    println(book1 == book2) // true
    println(book1 === book2) // false -> 이건 단지 객체의 메모리 주소를 비교하는 것

    val books = mutableSetOf<Book>()
    books.add(book1)
    books.add(book2)
    println(book1 == book2) // true

    // 출간일 신상 순서대로 정렬
    val book3 = Book("해리포터", "롤링", LocalDateTime.of(2025, 11, 10, 0, 0, 0))
    val book4 = Book("해리포터", "헤르미온느", LocalDateTime.of(2025, 11, 11, 0, 0, 0))
    val bookList = mutableListOf<Book>(book3, book4)

    val latestSortedBookList = bookList.sortedByDescending { it.publishedDate.toLocalDate() }
    println(latestSortedBookList)

    // deepCopy 확인
    val book5 = Book("해리포터", "헤르미온느", LocalDateTime.of(2025, 11, 11, 0, 0, 0))
    val book6 = book5.deepCopy()

    println(book5)
    println(book6)
}