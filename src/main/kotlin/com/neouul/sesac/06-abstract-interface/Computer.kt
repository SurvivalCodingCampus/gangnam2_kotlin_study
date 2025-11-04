package com.neouul.sesac.`06-abstract-interface`

class Computer(
    name: String,
    price: Int,
    color: String,
    var makerName: String,
) : TangibleAsset(name, price, color) {
}