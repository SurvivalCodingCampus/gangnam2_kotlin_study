package com.survivalcoding.kotlinstudy.`03_encapsulation`.practice

import kotlin.test.Test
import kotlin.test.assertEquals

class PersonTest {
    @Test
    fun `생성 확인`() {
        val person = Person("홍길동", 2000)

        assertEquals(person.name, "홍길동")
        assertEquals(person.birthYear, 2000)
        assertEquals(person.age, 25)
    }
}