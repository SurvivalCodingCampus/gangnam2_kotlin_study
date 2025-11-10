package com.sesac.practice.day06

class Book(
    name: String,
    price: Int,
    color: String,
    var isbn: String,
    weight: Double = BOOK_WEIGHT,
) : TangibleAsset(name, price, color, weight) {

    companion object {
        const val BOOK_WEIGHT: Double = 1.0
    }
}
