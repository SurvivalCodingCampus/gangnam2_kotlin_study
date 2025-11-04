package com.ezlevup.my.exercise2

class Computer(
    name: String,
    price: Int,
    color: String,
    var makerName: String,
    override var weight: Double,
) : TangibleAsset(name, price, color) {

}
