package com.ezlevup.my.exercise2

abstract class TangibleAsset(
    name: String,
    var price: Int,
    var color: String,
) : Asset(name), Thing {

}
