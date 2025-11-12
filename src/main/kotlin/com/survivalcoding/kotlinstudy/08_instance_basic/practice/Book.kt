package com.survivalcoding.kotlinstudy.`08_instance_basic`.practice

import java.time.LocalDate

/*
1번.

다음 동작을 할 수 있도록 Book 클래스를 수정하시오

1) 제목과 출간일(2024-01-01)이 같으면 같은 책으로 판단한다
2) Book 인스턴스를 담고 있는 컬렉션에 대해 sorted() 를 수행하면 출간일이 신상 순서대로 정렬되어야 함
3) 깊은 복사를 제공한다
*/

class PublishedDate(
    val publishedLocalDate: LocalDate = LocalDate.now()
) {
    override fun toString(): String {
        return "$publishedLocalDate"
    }

    override fun hashCode(): Int {
        return publishedLocalDate.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PublishedDate

        if (publishedLocalDate != other.publishedLocalDate) return false

        return true
    }

    fun deepCopy() = PublishedDate(publishedLocalDate)
}

class Book(
    val title: String,
    val author: String,
    val publishedDate: PublishedDate,
) : Comparable<Book> {
    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + author.hashCode()
        result = 31 * result + publishedDate.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (title != other.title) return false
//        if (author != other.author) return false  // 제목과 출간일만 같아야 하므로 작가는 제외
        if (publishedDate != other.publishedDate) return false

        return true
    }

    override fun toString(): String {
        return "Book(title: ${title}, author: ${author}, publishedDate: ${publishedDate})"
    }

    fun deepCopy() = Book(title, author, publishedDate.deepCopy())

    override fun compareTo(other: Book): Int {
        return other.publishedDate.publishedLocalDate.compareTo(this.publishedDate.publishedLocalDate)
    }
}
