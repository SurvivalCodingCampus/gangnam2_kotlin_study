package _251104_kotlin_oop

class Computer(
    name: String,
    price: Int,
    color: String,
    val isbn: String,
) : TangibleAsset(name, price, color) {
}