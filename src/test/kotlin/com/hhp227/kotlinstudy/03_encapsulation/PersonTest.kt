package com.hhp227.kotlinstudy.`03_encapsulation`

import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

class PersonTest {
    @Test
    fun `Person 클래스 검증`() {
        val currentYear = LocalDate.now().year
        val birthYear = 1999
        val expectedAge = currentYear - birthYear
        val person = Person("사람", birthYear)
        val age = person.age

        assertEquals(expectedAge, age)
    }
}