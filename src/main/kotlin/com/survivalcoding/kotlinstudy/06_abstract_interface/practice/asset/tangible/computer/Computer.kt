package com.survivalcoding.kotlinstudy.`06_abstract_interface`.practice.asset.tangible.computer

import com.survivalcoding.kotlinstudy.`06_abstract_interface`.practice.asset.tangible.TangibleAsset

class Computer(
    name: String,
    price: Int,
    color: String,
    var makerName: String,
    weight: Double,
) : TangibleAsset(name, price, color, weight) {
}