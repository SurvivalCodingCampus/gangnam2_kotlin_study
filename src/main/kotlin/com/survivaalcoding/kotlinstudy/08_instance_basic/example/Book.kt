package com.survivaalcoding.kotlinstudy.`08_instance_basic`.example

import java.time.LocalDateTime

class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = LocalDateTime.now()
) : Comparable<Book> {
    fun deepCopy(
        title: String = this.title,
        author: String = this.author,
        publishedDate: LocalDateTime = this.publishedDate
    ) = Book(
        title,
        author,
        publishedDate = LocalDateTime.of(publishedDate.toLocalDate(), publishedDate.toLocalTime())
    )

    override fun compareTo(other: Book): Int {
        return this.publishedDate.compareTo(other.publishedDate) * -1
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (title != other.title) return false
        if (publishedDate.toLocalDate() != other.publishedDate.toLocalDate()) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + publishedDate.hashCode()
        return result
    }

//    override fun toString(): String {
//        return "Book(title='$title', author='$author', publishedDate=$publishedDate)"
//    }


}