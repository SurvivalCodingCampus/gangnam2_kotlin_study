package com.ezlevup.my.exercise2

class Book(
    override var name: String,
    override var price: Int,
    override var color: String,
    var isbn: String,
) : TangibleAsset(name, price, color) {

}
