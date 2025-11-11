package com.survival.kotlinstudy.`06_interface`

class Computer(
    name: String,
    price: Int,
    color: String,
    var markerName: String,
    weight: Double,
) : TangibleAsset(name, price, color, weight) {
}