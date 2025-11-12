package com.neouul.sesac.`05-abstract-interface`

abstract class TangibleAsset(
    name: String,
    var price: Int,
    var color: String,
//    override var weight: Double,
) : Asset(name), Thing {
    abstract override var weight: Double
}