package com.sesac.practice.day11.lambda

import org.junit.Test
import kotlin.math.max
import kotlin.math.min
import kotlin.test.assertEquals

class QuizTest {
    val transactions = listOf(
        Transaction(Trader("Brian", "Cambridge"), 2011, 300),
        Transaction(Trader("Raoul", "Cambridge"), 2012, 1000),
        Transaction(Trader("Raoul", "Cambridge"), 2011, 400),
        Transaction(Trader("Mario", "Milan"), 2012, 710),
        Transaction(Trader("Mario", "Milan"), 2012, 700),
        Transaction(Trader("Alan", "Cambridge"), 2012, 950),
    )

    @Test
    fun `1) 2011년에 일어난 모든 트랜잭션을 찾아 가격 기준 오름차순으로 정리하여 이름을 나열하시오`() {
        val actual = transactions.filter { it.year == 2011 }
            .sortedBy { it.value }
            .map { it.trader.name }

        val expected = listOf(
            "Brian",
            "Raoul",
        )

        assertEquals(expected, actual)
    }

    @Test
    fun `2) 거래자가 근무하는 모든 도시를 중복 없이 나열하시오`() {
        val actual = transactions.map { it.trader.city }.distinct()

        val expected = listOf(
            "Cambridge",
            "Milan",
        )

        assertEquals(expected.sorted(), actual.sorted())
    }

    @Test
    fun `3) 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하여 나열하시오`() {
        val actual = transactions.filter { it.trader.city == "Cambridge" }
            .map { it.trader.name }
            .distinct()
            .sortedBy { it }

        val expected = listOf(
            "Alan",
            "Brian",
            "Raoul",
        )

        assertEquals(expected, actual)
    }

    @Test
    fun `4) 모든 거래자의 이름을 알파벳순으로 정렬하여 나열하시오`() {
        val actual = transactions.map { it.trader.name }
            .distinct()
            .sortedBy { it }

        val expected = listOf(
            "Alan",
            "Brian",
            "Mario",
            "Raoul",
        )

        assertEquals(expected, actual)
    }

    @Test
    fun `5) 밀라노에 거래자가 있는가`() {
        val actual = transactions.any { it.trader.city == "Milan" }

        val expected = true

        assertEquals(expected, actual)
    }

    @Test
    fun `6) 케임브리지에 거주하는 거래자의 모든 트랙잭션값을 출력하시오`() {
        val actual = transactions.filter { it.trader.city == "Cambridge" }

        val expected = listOf(
            Transaction(Trader("Brian", "Cambridge"), 2011, 300),
            Transaction(Trader("Raoul", "Cambridge"), 2012, 1000),
            Transaction(Trader("Raoul", "Cambridge"), 2011, 400),
            Transaction(Trader("Alan", "Cambridge"), 2012, 950),
        )

        val comparator = compareBy<Transaction>({ it.year }, { it.trader.name }, { it.trader.city })
        assertEquals(
            expected.sortedWith(comparator),
            actual.sortedWith(comparator),
        )
    }

    @Test
    fun `7) 전체 트랜잭션 중 최대값은 얼마인가`() {
        val actual = transactions.map { it.value }
            .reduce { acc, value -> max(acc, value) }

        val expected = 1000

        assertEquals(expected, actual)
    }

    @Test
    fun `8) 전체 트랜잭션 중 최소값은 얼마인가`() {
        val actual = transactions.map { it.value }
            .reduce { acc, value -> min(acc, value) }

        val expected = 300

        assertEquals(expected, actual)
    }
}
