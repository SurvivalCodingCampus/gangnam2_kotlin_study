package com.survivalcoding.kotlinstudy.`06_interface`.asset

abstract class TangibleAsset(
    name: String,
    price: Int,
    var color: String,
    override var weight: Double
) : Asset(name, price), Thing