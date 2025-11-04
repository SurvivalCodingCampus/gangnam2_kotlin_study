package com.survivalcoding.kotlinstudy.`06_abstract_class_interface`

// 연습문제 2. 가-나-다
// 가 : Asset
// 나 : IntangibleAsset
// 다 : Patent

// 연습문제 2. Asset 추상 클래스
abstract class Asset(
    var name: String,
    var price: Int,
)
