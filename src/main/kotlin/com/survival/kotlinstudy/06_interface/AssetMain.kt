package com.survival.kotlinstudy.`06_interface`

fun main() {
    val book: Thing = Book(
        name = "홍길동",
        price = 100,
        color = "파랑",
        isbn = "121212",
        weight = 10.0
    )
    val book2: Book = Book(
        name = "홍길동",
        price = 100,
        color = "파랑",
        isbn = "121212",
        weight = 10.0
    )

    val thing: Thing = Book(
        name = "홍길동",
        price = 100,
        color = "파랑",
        isbn = "121212",
        weight = 10.0
    )

    val thing2: Thing = Computer(
        name = "홍길동",
        price = 100,
        color = "파랑",
        markerName = "121212",
        weight = 10.0
    )

    val book5: Book = thing as Book
    val book6: Book = thing2 as Book


    if (book6 is Book) {

    }
}
