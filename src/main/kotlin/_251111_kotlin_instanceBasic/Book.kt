package _251111_kotlin_instanceBasic

import java.time.LocalDateTime

class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = LocalDateTime.now()
) : Comparable<Book> {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (publishedDate.toString().substring(0, 10) != other.publishedDate.toString().substring(0, 10)) return false
        if (title != other.title) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + author.hashCode()
        result = 31 * result + publishedDate.hashCode()
        return result
    }

    override fun toString(): String {
        return "Book(title='$title', author='$author', publishedDate=$publishedDate)"
    }

    override fun compareTo(other: Book): Int {
        if (this == other) return 0
        return this.publishedDate.toString().substring(0,10).compareTo(other.publishedDate.toString().substring(0,10)) * -1
    }
    fun deepCopy() = Book(title, author, publishedDate) //깊은 복사

}