package com.ezlevup.my.exercise2

class Book(
    name: String,
    price: Int,
    color: String,
    var isbn: String,
    override var weight: Double,
) : TangibleAsset(name, price, color) {

}
