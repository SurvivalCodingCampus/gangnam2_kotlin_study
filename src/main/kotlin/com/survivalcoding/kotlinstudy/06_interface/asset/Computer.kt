package com.survivalcoding.kotlinstudy.`06_interface`.asset

class Computer(
    name: String,
    price: Int,
    color: String,
    var makerName: String,
    weight: Double,
) : TangibleAsset(name, price, color, weight)