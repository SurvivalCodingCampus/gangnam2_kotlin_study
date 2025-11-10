package com.sesac.practice.day06

class Computer(
    name: String,
    price: Int,
    color: String,
    var makerName: String,
    weight: Double = COMPUTER_WEIGHT,
) : TangibleAsset(name, price, color, weight) {

    companion object {
        const val COMPUTER_WEIGHT: Double = 5.0
    }
}
