package com.sesac.practice.day06

abstract class TangibleAsset(
    name: String,
    var price: Int,
    var color: String,
) : Asset(name)
