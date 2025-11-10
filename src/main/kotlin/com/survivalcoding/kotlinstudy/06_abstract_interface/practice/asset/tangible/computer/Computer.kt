package com.survivalcoding.kotlinstudy.`06_abstract_interface`.practice.asset.tangible.computer

import com.survivalcoding.kotlinstudy.`06_abstract_interface`.practice.asset.tangible.TangibleAsset

class Computer(
    name: String,
    price: Int,
    color: String,
    var makerName: String
) : TangibleAsset(name, price, color) {
}