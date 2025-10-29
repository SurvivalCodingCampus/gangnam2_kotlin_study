package com.survivalcoding.kotlinstudy.`02_instance_class`

import junit.framework.TestCase.assertTrue
import kotlin.test.Test
import kotlin.test.assertEquals

class ClericTest {
    @Test
    fun `selfAid()가 잘 작동하는지 확인`(){
        val cleric = Cleric(name = "승엽")

        cleric.selfAid()

        assertEquals(5, cleric.mp)
    }

    @Test
    fun `pray()가 잘 작동하는지 확인`(){
        val cleric = Cleric(name = "승엽")

        cleric.selfAid()
        val pray = cleric.pray(4)

        assertTrue(pray in 4..5)
    }
}