package com.luca.kotlinstudy._11_file

import org.junit.Assert.*
import org.junit.Test

class RuntimeErrorTest {
    @Test
    fun `변환 불가시 0으로 처리`() {
        val result = safeToInt("10.5")
        assertEquals(0, result)
    }
}