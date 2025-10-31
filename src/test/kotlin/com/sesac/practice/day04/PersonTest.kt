package com.sesac.practice.day04

import org.junit.Test
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PersonTest {
    @Test
    fun `Person 을 생성한다`() {
        // given
        val name = "test"
        val birthYear = 2020

        // when
        val person = Person(name, birthYear)

        // then
        assertEquals(name, person.name)
        assertEquals(birthYear, person.birthYear)
        assertTrue(person.age > 0)
    }

    @Test
    fun `Person 나이는 올해년도에서 birthYear를 뺀 값이다`() {
        // given
        val name = "test"
        val birthYear = 2020
        val now = LocalDate.of(2020, 1, 1)

        // when
        val person = Person(name, birthYear, now)

        // then
        assertEquals(now.year - birthYear, person.age)
    }
}
