package _251104_kotlin_oop

class Book(
    name: String,
    price: Int,
    color: String,
    val isbn: String,
    override var weight: Double,

    ) : TangibleAsset(name, price, color) {

}