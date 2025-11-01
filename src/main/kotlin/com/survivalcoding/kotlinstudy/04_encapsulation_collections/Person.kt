package com.survivalcoding.kotlinstudy.`04_encapsulation_collections`

import java.time.Year

// 연습문제 2. Person class
class Person2(
    val name: String,   // 생성자, 수정 불가
    val birthYear: Int, // 생성자, 수정 불가
) {
    init {
        require(name.isNotEmpty()) { "이름은 비어 있을 수 없습니다." }
        require(birthYear <= Year.now().value) { "출생 연도는 미래일 수 없습니다." }
    }

    // 올해 연도
    private val thisYear: Int = Year.now().value

    // age 프로퍼티 - 나이 계산
    var age: Int = thisYear - birthYear
        private set
}