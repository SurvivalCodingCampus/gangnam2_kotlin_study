package com.sesac.practice.day06

class Computer(
    name: String,
    price: Int,
    color: String,
    var makerName: String,
) : TangibleAsset(name, price, color)
