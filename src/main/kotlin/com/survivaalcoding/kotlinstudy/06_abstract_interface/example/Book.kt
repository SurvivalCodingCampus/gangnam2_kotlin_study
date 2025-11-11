package com.survivaalcoding.kotlinstudy.`06_abstract_interface`.example

class Book(
    weight: Double,
    name: String,
    price: Int,
    stock: Int,
    color: String,
    isbn: String,
) : TangibleAsset(weight, name, price, stock, color) {
    var isbn = isbn
        private set

    override fun getInfo(): String {
        return """
            명칭: $name
            무게: $weight
            가격: $price
            재고: $stock
            색상: $color
            상품번호: $isbn
        """.trimIndent()
    }

}