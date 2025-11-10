package com.survivalcoding.kotlinstudy.`06_abstract_interface`.practice.asset.tangible.book

import com.survivalcoding.kotlinstudy.`06_abstract_interface`.practice.asset.tangible.TangibleAsset

class Book(
    name: String,
    price: Int,
    color: String,
    var isbn: String,
    weight: Double
) : TangibleAsset(name, price, color, weight) {
}