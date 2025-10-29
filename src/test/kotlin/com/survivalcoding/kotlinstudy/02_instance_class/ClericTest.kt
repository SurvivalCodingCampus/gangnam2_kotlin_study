package com.survivalcoding.kotlinstudy.`02_instance_class`

import org.junit.Assert.*
import kotlin.test.Test

class ClericTest {
    @Test
    fun `Self Aid Test`() {
        // given(준비)
        val cleric = Cleric("성직자")

        // when(실행)
        cleric.selfAid()

        // then(검중)
        assertEquals(5 , cleric.mp)

    }

    @Test
    fun `Pray Test`() {
        // given(준비)
        val cleric = Cleric("성직자")
        cleric.selfAid()// MP 5 소모 → mp = 5

        // when(실행)
        cleric.pray(4) //

        // then(검중)
        assertTrue(cleric.mp in 9..MAX_MP)
    }


}