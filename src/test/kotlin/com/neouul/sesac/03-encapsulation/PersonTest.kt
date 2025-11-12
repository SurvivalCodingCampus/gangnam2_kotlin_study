package com.neouul.sesac.`03-encapsulation`

import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDate

class PersonTest {
    companion object {
        const val NAME = "최강"
        const val BIRTH_YEAR = 2004
        val LOCAL_YEAR = LocalDate.now().year
    }

    @Test
    fun `Person 생성자`() {
        val person = Person(NAME, BIRTH_YEAR)

        assertEquals(NAME, person.name)
        assertEquals(BIRTH_YEAR, person.birthYear)
    }

    @Test
    fun `Person의 age 필드를 통해 나이를 제공받는다`() {
        // given
        val person = Person(NAME, BIRTH_YEAR)

        // when
        val age = person.age

        // then
        assertEquals(LOCAL_YEAR - BIRTH_YEAR, age)
    }

    @Test
    fun `Person의 calculateAge() 메서드를 통해 나이를 리턴받는다`() {
        // given
        val person = Person(NAME, BIRTH_YEAR)

        // when
        val age = person.calculateAge()

        // then
        assertEquals(LOCAL_YEAR - BIRTH_YEAR, age)
    }
}