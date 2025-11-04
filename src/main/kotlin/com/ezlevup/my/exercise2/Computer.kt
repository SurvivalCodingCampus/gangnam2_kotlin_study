package com.ezlevup.my.exercise2

class Computer(
    override var name: String,
    override var price: Int,
    override var color: String,
    var makerName: String,
    override var weight: Double,
) : TangibleAsset(name, price, color) {

}
