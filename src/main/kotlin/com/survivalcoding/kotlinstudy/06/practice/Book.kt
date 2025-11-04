package com.survivalcoding.kotlinstudy.`06`.practice

class Book(
    name: String,
    price: Int,
    color: String,
    var isbn: String
) : TangibleAsset(name, price, color) {
}