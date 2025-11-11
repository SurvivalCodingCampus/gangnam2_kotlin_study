package com.sesac.practice.day08

import java.time.LocalDateTime

class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = LocalDateTime.now(),
) : Comparable<Book> {
    fun deepCopy(
        title: String = this.title,
        author: String = this.author,
        publishedDate: LocalDateTime = this.publishedDate,
    ) = Book(
        title,
        author,
        LocalDateTime.of(
            publishedDate.year,
            publishedDate.monthValue,
            publishedDate.dayOfMonth,
            publishedDate.hour,
            publishedDate.minute,
            publishedDate.second,
        ),
    )

    override fun compareTo(other: Book): Int {
        return other.publishedDate.compareTo(this.publishedDate)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (title != other.title) return false
        if (publishedDate.year != other.publishedDate.year) return false
        if (publishedDate.monthValue != other.publishedDate.monthValue) return false
        if (publishedDate.dayOfMonth != other.publishedDate.dayOfMonth) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + publishedDate.year
        result = 31 * result + publishedDate.monthValue
        result = 31 * result + publishedDate.dayOfMonth
        return result
    }

    override fun toString(): String {
        return "Book(title='$title', author='$author', publishedDate=$publishedDate)"
    }
}
