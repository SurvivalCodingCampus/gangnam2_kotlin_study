package com.neouul.sesac.`06-abstract-interface`

class Computer(
    name: String,
    price: Int,
    color: String,
    var makerName: String,
    override var weight: Double,
) : TangibleAsset(name, price, color) {
}