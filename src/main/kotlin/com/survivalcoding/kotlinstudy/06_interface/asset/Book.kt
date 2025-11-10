package com.survivalcoding.kotlinstudy.`06_interface`.asset

class Book(
    name: String,
    price: Int,
    color: String,
    var isbn: String,
    weight: Double,
) : TangibleAsset(name, price, color, weight)