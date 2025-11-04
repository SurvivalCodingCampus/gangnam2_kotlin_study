package com.ezlevup.my.exercise2

class Book(
    override var name: String,
    override var price: Int,
    override var color: String,
    var isbn: String,
    override var weight: Double,
) : TangibleAsset(name, price, color) {

}
