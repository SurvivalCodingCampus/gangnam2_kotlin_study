package com.survival.kotlinstudy.`03_encapsulation`

import org.junit.Test
import java.time.LocalDate
import kotlin.test.assertEquals

class PersonTest {
    @Test
    fun `Person 인스턴스 생성 - 나이 테스트`() {
        // given (준비)
        val name = "김이박"
        val birthYear = 2000
        val age = LocalDate.now().year - birthYear
        val person = Person(name = name, birthYear = birthYear)
        // when (실행)

        // then (검증)
        assertEquals(name, person.name)
        assertEquals(birthYear, person.birthYear)
        assertEquals(age, person.age)
    }
}