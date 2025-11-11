package com.survivaalcoding.kotlinstudy.`07_polymorphism`

import com.survivaalcoding.kotlinstudy.`06_abstract_interface`.example.Asset
import com.survivaalcoding.kotlinstudy.`06_abstract_interface`.example.Book
import com.survivaalcoding.kotlinstudy.`06_abstract_interface`.example.Thing

fun main() {
    val book: Thing = Book(
        weight = 10.0,
        name = "name",
        price = 10_000,
        stock = 10,
        color = "black",
        isbn = "001"
    )

    val book2: Asset = Book(
        weight = 10.0,
        name = "name",
        price = 10_000,
        stock = 10,
        color = "black",
        isbn = "001"
    )

}
