package com.hhp227.kotlinstudy.`11_lambda`

import junit.framework.TestCase.assertTrue
import kotlin.test.Test
import kotlin.test.assertEquals

class LambdaPracticeTest {
    private val lambdaPractice = LambdaPractice()

    @Test
    fun `2011년 트랜잭션을 기준으로 오름차순 정렬후 이름만 출력하는지 테스트`() {
        val result = lambdaPractice.getSolution1()
        val expected = listOf("Brian", "Raoul") // 300 → Brian, 400 → Raoul

        assertEquals(expected, result)
    }

    @Test
    fun `거래자가 근무하는 모든 도시 중복없는지 테스트`() {
        val result = lambdaPractice.getSolution2()

        assertEquals(setOf("Cambridge", "Milan"), result)
    }

    @Test
    fun `거래자의 도시중 케임브리지인 사람들이 이름순으로 정렬하여 출력하는지 테스트`() {
        val result = lambdaPractice.getSolution3()
        val expected = listOf(
            Transaction(Trader("Alan", "Cambridge"), 2012, 950),
            Transaction(Trader("Brian", "Cambridge"), 2011, 300),
            Transaction(Trader("Raoul", "Cambridge"), 2012, 1000),
            Transaction(Trader("Raoul", "Cambridge"), 2011, 400),
        )

        assertEquals(expected, result)
    }

    @Test
    fun `모든 거래자의 이름을 알파벳 순으로 정렬되어있는지 테스트`() {
        val result = lambdaPractice.getSolution4()
        val expected = listOf("Alan", "Brian", "Mario", "Mario", "Raoul", "Raoul")

        assertEquals(expected, result)
    }

    @Test
    fun `거래자의 도시중 밀라노인 사람이 있는지 테스트`() {
        val result = lambdaPractice.solution5()

        assertTrue(result)
    }

    @Test
    fun `거래자의 도시중 케임브리지인 사람들의 모든 트랜잭션값을 출력하는지 테스트`() {
        val result = lambdaPractice.solution6()

        assertEquals(4, result.size)
        assertTrue(result.all { it.trader.city == "Cambridge" })
    }

    @Test
    fun `전체 트랜잭션 중 최대값을 출력하는지 테스트`() {
        val result = lambdaPractice.solution7()

        assertEquals(1000, result)
    }

    @Test
    fun `전체 트랜잭션 중 최소값을 출력하는지 테스트`() {
        val result = lambdaPractice.solution8()

        assertEquals(300, result)
    }
}