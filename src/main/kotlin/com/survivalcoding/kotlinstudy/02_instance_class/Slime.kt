package com.survivalcoding.kotlinstudy.`02_instance_class`

// const val SLIME_LEVEL = 10 <- 이것도 가능


fun main() {
    val slime = Slime(10) // 기본 생성자가 없었으므로 무조건 값을 넣어주어야 함
}

class Slime (hp: Int) {
    val level = 10 // 변하지 않음
}