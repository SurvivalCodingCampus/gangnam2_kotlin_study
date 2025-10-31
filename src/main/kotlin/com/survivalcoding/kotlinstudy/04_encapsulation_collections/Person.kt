package com.survivalcoding.kotlinstudy.`04_encapsulation_collections`

import java.time.Year

// 연습문제 2. Person class
class Person(
    val name: String,   // 생성자, 수정 불가
    val birthYear: Int, // 생성자, 수정 불가
) {
    // 올해 연도
    private val thisYear: Int = Year.now().value

    // age 프로퍼티 - 나이 계산
    var age: Int = thisYear - birthYear
        private set
}