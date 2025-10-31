package com.survivalcoding.kotlinstudy.`04_encapsulation_collections`

// 연습문제 1-1. 클래스 작성
class Wand(
    name: String,   // 이름
    power: Double,  // 마력
) {
    // 연습문제 1-2 타당성 검사
    var name: String = name
        set(value) {
            require(value.isNotEmpty()) { "지팡이 이름은 비어있을 수 없습니다." }  // 지팡이 이름 제한
            require(value.length >= 3) { "지팡이 이름은 3글자 이상이어야 합니다." }
            field = value
        }

    var power: Double = power
        set(value) {
            require(value in 0.5..100.0) { "지팡이의 마력은 0.5 이상 100.0 이하여야 합니다." }  // 지팡이 마력 제한 0.5 이상 100.0 이하
            field = value
        }
}

// 연습문제 1-1. 클래스 작성
class Wizard(
    name: String,
    mp: Int,
    hp: Int,
    var wand: Wand?,
) {
    // 연습문제 1-2 타당성 검사
    var name: String = name
        set(value) {
            require(value.isNotEmpty()) { "마법사 이름은 비어 있을 수 없습니다." } // 마법사 이름 제한
            require(value.length >= 3) { "마법사 이름은 3글자 이상이어야 합니다." }
            field = value
        }

    var mp: Int = mp
        set(value) {
            require(value >= 0) { "MP는 0 이상이어야 합니다." }  // mp는 0 이상
            field = value
        }

    var hp: Int = hp
        set(value) {
            field = if (value < 0) 0 else value  // hp 음수면 0으로 설정
        }
}