package com.survivalcoding.kotlinstudy.`06_abstract_class_interface`

// 연습문제 1. 추상 클래스 활용
abstract class TangibleAsset(
    name: String,
    price: Int,
    var color: String,
) : Asset(name, price), Thing   // 연습문제 2. Asset 클래스 상속, 연습문제 4. interface 구현