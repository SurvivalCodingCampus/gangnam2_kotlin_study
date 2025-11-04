package com.neouul.sesac.`06-abstract-interface`

class Book(
    name: String,
    price: Int,
    color: String,
    var isbn: String,
    override var weight: Double,
) : TangibleAsset(name, price, color) {
}