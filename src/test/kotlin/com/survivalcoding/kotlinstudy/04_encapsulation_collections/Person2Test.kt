package com.survivalcoding.kotlinstudy.`04_encapsulation_collections`

import java.time.Year
import kotlin.test.Test
import kotlin.test.assertEquals

class Person2Test {
    private val validName = "홍길동"
    private val validBirthYear = 2000

    @Test
    fun `나이 계산 성공`() {
        // given
        val thisYear = Year.now().value
        val calculatedAge = thisYear - validBirthYear

        // when
        val person = Person2(name = validName, birthYear = validBirthYear)

        // then
        assertEquals(calculatedAge, person.age)
    }
}
