package com.survivalcoding.kotlinstudy.`06_abstract_class_interface`

// 연습문제 1. 추상 클래스 활용
class Book(
    name: String,
    price: Int,
    color: String,
    var isbn: String,
) : TangibleAsset(name, price, color)