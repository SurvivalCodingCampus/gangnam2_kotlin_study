package com.ezlevup.my.day251111.exercise

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun LocalDateTime.toDateString(): String {
    return this.format(DateTimeFormatter.ofPattern("yyMMdd"))
}


class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = LocalDateTime.now(),
) : Comparable<Book> {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (title != other.title) return false
        if (publishedDate.toDateString() != other.publishedDate.toDateString()) return false

        return true
    }

    override fun toString(): String {
        return "$title / $author / ${publishedDate.toString()}"
    }

    override fun compareTo(other: Book): Int {
        return other.publishedDate.compareTo(this.publishedDate)
    }

    fun deepCopy(): Book {
        return Book(this.title, this.author, this.publishedDate)
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + author.hashCode()
        result = 31 * result + publishedDate.hashCode()
        return result
    }
}


fun main() {
    var books = mutableListOf<Book>()
    books.add(Book("A", "a", LocalDateTime.of(2025, 11, 1, 0, 0)))
    books.add(Book("B", "b", LocalDateTime.of(2025, 10, 1, 0, 0)))
    books.add(Book("C", "c", LocalDateTime.of(2025, 12, 1, 0, 0)))

    println("정렬 전")
    books.forEach { t -> println(t) }

    println("==========================================================")
    //books.sortWith(compareByDescending { it.publishedData })
    //books.forEach { t -> println(t) }

    println("정렬 후")
    val sortedBooks = books.sorted()
    sortedBooks.forEach { t -> println(t) }

    println("==========================================================")

    val book1 = Book("A", "a", LocalDateTime.of(2025, 11, 1, 0, 0))
}
