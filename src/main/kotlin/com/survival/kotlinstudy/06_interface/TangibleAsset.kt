package com.survival.kotlinstudy.`06_interface`

abstract class TangibleAsset(
    name: String,
    price: Int,
    var color: String,
) : Asset(name, price), Thing {
    override var weight: Double = 0.0
}