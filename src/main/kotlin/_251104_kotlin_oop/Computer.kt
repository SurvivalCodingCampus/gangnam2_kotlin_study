package _251104_kotlin_oop

class Computer(
    name: String,
    price: Int,
    color: String,
    val makerName: String,
    override var weight: Double,
) : TangibleAsset(name, price, color) {


}