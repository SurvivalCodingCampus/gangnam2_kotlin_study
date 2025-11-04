package _251104_kotlin_oop

abstract class TangibleAsset(
    name: String,
    price: Int,
    var color: String

) : Asset(name, price), Thing {

}