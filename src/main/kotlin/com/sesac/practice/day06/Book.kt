package com.sesac.practice.day06

class Book(
    name: String,
    price: Int,
    color: String,
    var isbn: String,
) : TangibleAsset(name, price, color)
