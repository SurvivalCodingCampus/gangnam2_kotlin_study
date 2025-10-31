package com.survivalcoding.kotlinstudy.`04_encapsulation_collections`

class Wand(
    var name: String,   // 이름
    var power: Double,  // 마력
)

class Wizard(
    var name: String,
    var hp: Int,
    var wand: Wand?,
)