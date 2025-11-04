package com.survivaalcoding.kotlinstudy.`06_abstract_interface`.example

abstract class TangibleAsset(
    override var weight: Double,
    name: String,
    price: Int,
    stock: Int,
    color: String
) : Asset(name, price), Thing {
    var stock = stock
        private set

    var color = color
        private set

    fun decreaseStock(quantity: Int) {
        if (!isAvailableRental(quantity)) {
            throw IllegalArgumentException("재고가 부족합니다.")
        }

        stock -= quantity
    }

    fun rental(quantity: Int): Boolean {
        if (!isAvailableRental(quantity)) {
            return false
        }

        decreaseStock(quantity)

        return true
    }

    private fun isAvailableRental(quantity: Int): Boolean {
        return stock > quantity
    }
}