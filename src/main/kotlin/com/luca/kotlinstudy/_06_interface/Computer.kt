package com.luca.kotlinstudy._06_interface

class Computer (
    name: String,
    price: Int,
    color: String,
    var makerName: String,
) : TangibleAsset(name, price, color) {

}