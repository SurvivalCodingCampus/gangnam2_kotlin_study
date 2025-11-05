package com.luca.kotlinstudy._06_interface

class Book(
    name: String,
    price: Int,
    color: String,
    override var weight: Double,
    var isbn: String,
) : TangibleAsset(name, price, color, weight) {

}