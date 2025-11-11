package com.luca.kotlinstudy._08_instance_basic
/*
다음 동작을 할 수 있도록 Book 클래스를 수정하시오

제목과 출간일(2024-01-01)이 같으면 같은 책으로 판단한다
Book 인스턴스를 담고 있는 컬렉션에 대해 sorted() 를 수행하면 출간일이 신상 순서대로 정렬되어야 함
깊은 복사를 제공한다

 */
import java.time.LocalDateTime

class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = LocalDateTime.now(),
) : Comparable<Book> {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Book) return false
        val sameBook =
            this.title == other.title && this.publishedDate.toLocalDate() == other.publishedDate.toLocalDate()
        return sameBook
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + publishedDate.toLocalDate().hashCode() // 31은 소수다. = 소수를 쓰면 분포가 넓게 퍼지기 때문에 해시 테이블 성능이 좋아진다.
        return result
    }

    override fun compareTo(other: Book): Int =
        other.publishedDate.compareTo(this.publishedDate)

    fun deepCopy(): Book {
        val newDate = LocalDateTime.of(
            publishedDate.year,
            publishedDate.month,
            publishedDate.dayOfMonth,
            publishedDate.hour,
            publishedDate.minute,
            publishedDate.second,
            publishedDate.nano
        )
        return Book(title, author, newDate)
    }
}

