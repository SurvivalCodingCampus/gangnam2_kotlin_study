package com.survival.kotlinstudy.`07_instance_basic`

import java.time.LocalDateTime

class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = LocalDateTime.now(),
) : Comparable<Book> {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        return title == other.title &&
                this.publishedDate.toLocalDate() == other.publishedDate.toLocalDate()
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + publishedDate.toLocalDate().hashCode()
        return result

    }

    override fun toString(): String {
        return "Book(title='$title', author='$author', publishedDate=$publishedDate)"
    }

    override fun compareTo(other: Book): Int {
        if (this == other) return 0

        return this.publishedDate.toLocalDate().compareTo(other.publishedDate.toLocalDate()) * -1
    }

    fun deepCopy(
        title: String = this.title,
        author: String = this.author,
        publishedDate: LocalDateTime = this.publishedDate,
    ) = Book(
        title,
        author,
        LocalDateTime.of(
            publishedDate.toLocalDate(), publishedDate.toLocalTime()
        ),
    )
}