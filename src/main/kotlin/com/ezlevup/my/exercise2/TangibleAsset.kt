package com.ezlevup.my.exercise2

abstract class TangibleAsset(
    name: String,
    price: Int,
    var color: String,
    override var weight: Double,
) : Asset(name, price), Thing {

}
