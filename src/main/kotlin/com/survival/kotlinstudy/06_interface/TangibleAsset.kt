package com.survival.kotlinstudy.`06_interface`

abstract class TangibleAsset(
    name: String,
    price: Int,
    var color: String,
) : Asset(name,price) {

}