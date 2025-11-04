package com.luca.kotlinstudy._06_interface

abstract class IntangibleAsset(
    name: String,
    price: Int,
    var registrant: String, // 등록자(소유자)
) : Asset(name, price) {
}