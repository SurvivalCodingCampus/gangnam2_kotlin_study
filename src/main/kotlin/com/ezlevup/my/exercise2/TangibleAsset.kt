package com.ezlevup.my.exercise2

abstract class TangibleAsset(
    override var name: String,
    open var price: Int,
    open var color: String,
) : Asset(name), Thing {

}
