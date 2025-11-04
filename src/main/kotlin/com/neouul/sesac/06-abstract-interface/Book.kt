package com.neouul.sesac.`06-abstract-interface`

class Book(
    name: String,
    price: Int,
    color: String,
    var isbn: String,
) : TangibleAsset(name, price, color) {
}