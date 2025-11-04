package com.survivalcoding.kotlinstudy.`06_abstract_class_interface`

// 연습문제 1. 추상 클래스 활용
class Computer(
    name: String,
    price: Int,
    color: String,
    var makerName: String,
    override var weight: Double // 연습문제 4. 필드 추가
) : TangibleAsset(name, price, color), Thing