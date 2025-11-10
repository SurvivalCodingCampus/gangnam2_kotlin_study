package com.luca.kotlinstudy._06_interface

// 특허
class Patent(
    name: String,
    price: Int,
    registrant: String,       // 등록자
    val patentNumber: String, // 특허번호
) : IntangibleAsset(name, price, registrant)