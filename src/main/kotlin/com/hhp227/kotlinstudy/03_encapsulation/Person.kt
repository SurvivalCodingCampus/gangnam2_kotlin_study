package com.hhp227.kotlinstudy.`03_encapsulation`

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.format.DateTimeFormatter

/*
연습문제2
Person 클래스를 작성하시오.

이름과 태어난 해를 생성자로 받는다 (name, birthYear)
이름과 태어난 해는 한번 정해지면 수정이 불가능하다.
age 프로퍼티를 통해 나이를 제공하지만, 임의로 수정은 불가능하다.
나이 계산은 올해년도에서 birthYear 년도를 뺀 값을 리턴한다
현재 시간과 날짜를 구하는 방법은 검색 해 볼 것
 */

class Person(
    val name: String,
    val birthYear: Int
) {
    val age: Int
        get() {
            val formatter = DateTimeFormatter.ofPattern("yyyy")
            return LocalDate.now().format(formatter).toInt() - birthYear
        }
}