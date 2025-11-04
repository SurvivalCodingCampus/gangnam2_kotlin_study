package com.ezlevup.my.exercise2

class Computer(
    override var name: String,
    override var price: Int,
    override var color: String,
    var makerName: String,
) : TangibleAsset(name, price, color) {

}
