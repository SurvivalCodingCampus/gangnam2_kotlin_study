package com.survivalcoding.kotlinstudy.`06_interface`.asset

fun main() {
    val book: Book = Book(
        name = "생존코딩",
        price = 100,
        color = "파랑",
        isbn = "123123",
        weight = 100.0,
    )

    val thing1: Thing = Book(
        name = "생존코딩",
        price = 100,
        color = "파랑",
        isbn = "123123",
        weight = 100.0,
    )

    val thing2: Thing = Computer(
        name = "생존코딩",
        price = 100,
        color = "파랑",
        makerName = "123123",
        weight = 100.0,
    )

    val book3: Book = thing1 as Book
    val book4: Book = thing2 as Book

    if (thing2 is Book) {
        // smart cast
        val book5: Book = thing2
    }
}