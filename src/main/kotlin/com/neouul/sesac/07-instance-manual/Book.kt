package com.neouul.sesac.`07-instance-manual`

import java.time.LocalDateTime

class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = LocalDateTime.now(),
) : Comparable<Book> {
    override fun compareTo(other: Book): Int {
        if (this == other) return 0

        if (this.publishedDate == other.publishedDate) return 0

        // other보다 이전에 출간했다면 1 리턴, 이후라면 -1 리턴
        // sorted는 기본적으로 오름차순, 즉 먼저 두고 싶은 쪽이 작은쪽으로 생각해서 -1 리턴해야함
        return if (this.publishedDate.isBefore(other.publishedDate)) 1 else -1
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