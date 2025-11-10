package com.survival.kotlinstudy.`06_interface`

class Book(
    name: String,
    price: Int,
    color: String,
    var isbn: String,
) : TangibleAsset(name, price, color) {

}