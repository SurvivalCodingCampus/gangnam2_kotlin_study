package com.survivalcoding.kotlinstudy.`03_encapsulation`.practice

class Wand(
    name: String,   // 이름
    power: Double,  // 마력
) {
    var name: String = name
        set(value) {
            if (value.length < 3) {
                throw IllegalArgumentException("이름이 3자 이상이어야 합니다.")
            }

            if (value.length > 8) {
                throw IllegalArgumentException("이름이 8자 이하이어야 합니다.")
            }

            if (value.contains(" ")) {
                throw IllegalArgumentException("이름에 공백이 포함되어 있습니다.")
            }

            if (value.contains(Regex("[^A-Za-z0-9가-힣]"))) {
                throw IllegalArgumentException("이름에 특수문자가 포함되어 있습니다.")
            }

            field = value
        }

    var power: Double = power
        set(value) {
            if (value !in 0.5..100.0) {
                throw IllegalArgumentException("주어진 마력의 범위와 다릅니다.")
            }

            field = value
        }
}