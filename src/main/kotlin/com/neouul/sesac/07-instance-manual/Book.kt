package com.neouul.sesac.`07-instance-manual`

import java.time.LocalDateTime

class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = LocalDateTime.now(),
) : Comparable<LocalDateTime> {
    override fun compareTo(other: LocalDateTime): Int {
        if (this == other) return 0

        // other보다 이전에 출간했다면 -1 리턴, 이후라면 1 리턴
        return if (this.publishedDate.isBefore(other)) -1 else 1
    }

    override fun toString(): String {
        return "Book(title='$title', author='$author', publishedDate=$publishedDate)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (title != other.title) return false
        if (publishedDate.year != other.publishedDate.year) return false
        if (publishedDate.month != other.publishedDate.month) return false
        if (publishedDate.dayOfMonth != other.publishedDate.dayOfMonth) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + author.hashCode()
        result = 31 * result + publishedDate.hashCode()
        return result
    }

    fun deepCopy() = Book(title, author, publishedDate.deepCopy())
}

fun LocalDateTime.deepCopy(): LocalDateTime {
//    return LocalDateTime.of(this.year, this.month, this.dayOfMonth, 0, 0, 0)
    return LocalDateTime.of(
        this.year,
        this.month,
        this.dayOfMonth,
        this.hour,
        this.minute,
        this.second,
    )
}

fun main(){
    val b1 = Book("1", "sk", LocalDateTime.of(2025,11,1,0,0,0))

    val b2 = Book("1", "sk", LocalDateTime.of(2025,11,3,0,0,0))

    val list = listOf<Book>(b1, b2)
    val sortedList = list.sorted()
}