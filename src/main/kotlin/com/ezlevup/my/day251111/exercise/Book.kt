package com.ezlevup.my.day251111.exercise

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

        if (title != other.title) return false
        if (publishedDate.toLocalDate() != other.publishedDate.toLocalDate()) return false

        return true
    }

    override fun toString(): String {
        return "${title} / ${author} / ${publishedDate.toString()}"
    }

    override fun compareTo(other: Book): Int {
        return other.publishedDate.compareTo(this.publishedDate)
    }

    fun deepCopy(book: Book): Book {
        return Book(book.title, book.author, book.publishedDate)
    }
}


fun main() {
    var books = mutableListOf<Book>()
    books.add(Book("A", "a", LocalDateTime.of(2025, 11, 1, 0, 0)))
    books.add(Book("B", "b", LocalDateTime.of(2025, 10, 1, 0, 0)))
    books.add(Book("C", "c", LocalDateTime.of(2025, 12, 1, 0, 0)))

    books.forEach { t -> println(t) }

    println("==========================================================")
    //books.sortWith(compareByDescending { it.publishedData })
    //books.forEach { t -> println(t) }

    val sortedBooks = books.sorted()
    sortedBooks.forEach { t -> println(t) }

}
