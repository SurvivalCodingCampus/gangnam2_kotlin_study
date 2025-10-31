package com.hhp227.kotlinstudy.`03_encapsulation`

import kotlin.test.Test
import kotlin.test.assertEquals

class PersonTest {
    @Test
    fun `Person 클래스 검증`() {
        val person = Person("사람", 1999)
        val age = person.age

        assertEquals(26, age)
    }
}