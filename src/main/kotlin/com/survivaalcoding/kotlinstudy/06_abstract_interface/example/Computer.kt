package com.survivaalcoding.kotlinstudy.`06_abstract_interface`.example

class Computer(
    override var weight: Double,
    name: String,
    price: Int,
    stock: Int,
    color: String,
    makeNamee: String
) : TangibleAsset(weight, name, price, stock, color){
    var makeNamee = makeNamee
        private set

    override fun getInfo(): String {
        return """
            명칭: $name
            무게: $weight
            가격: $price
            재고: $stock
            색상: $color
            제조사: $makeNamee
        """.trimIndent()
    }
}