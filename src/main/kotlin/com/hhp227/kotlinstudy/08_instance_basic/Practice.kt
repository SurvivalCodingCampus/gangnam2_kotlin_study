package com.hhp227.kotlinstudy.`08_instance_basic`

import java.time.LocalDateTime

/*
연습문제
다음과 같은 Book 클래스가 있다.

class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = LocalDateTime.now()
)
다음 동작을 할 수 있도록 Book 클래스를 수정하시오

1.제목과 출간일(2024-01-01)이 같으면 같은 책으로 판단한다
2.Book 인스턴스를 담고 있는 컬렉션에 대해 sorted() 를 수행하면 출간일이 신상 순서대로 정렬되어야 함
3.깊은 복사를 제공한다
 */

class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = LocalDateTime.now()
) : Comparable<Book> {
    override fun equals(other: Any?): Boolean {
        return this.title == (other as? Book)?.title && publishedDate == other.publishedDate
    }

    override fun compareTo(other: Book): Int {
        return this.publishedDate.compareTo(other.publishedDate)
    }

    fun deepCopy(
        title: String = this.title,
        author: String = this.author,
        publishedDate: LocalDateTime = this.publishedDate
    ): Book {
        return Book(title, author, publishedDate.copy())
    }
}

fun LocalDateTime.copy(): LocalDateTime {
    return LocalDateTime.of(this.year, this.month, this.dayOfMonth, this.hour, this.minute, this.second, this.nano)
}