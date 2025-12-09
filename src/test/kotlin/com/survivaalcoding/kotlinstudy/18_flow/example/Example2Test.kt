package com.survivaalcoding.kotlinstudy.`18_flow`.example

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class Example2Test {

    @Test
    fun `flowA를 얻을 수 있다`() = runTest {
        // given
        val expected = listOf("A1", "A2", "A3")
        val flowA = Example2.getFlowA(expected)
        val actual = mutableListOf<String>()

        // when
        flowA.collect { actual.add(it) }

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `flowB를 얻을 수 있다`() = runTest {
        // given
        val expected = listOf("B1", "B2", "B3", "B4")
        val flowB = Example2.getFlowB(expected)
        val actual = mutableListOf<String>()

        // when
        flowB.collect { actual.add(it) }

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `flowA, flowB의 zip한 결과를 얻을 수 있다`() = runTest {
        // given
        val list1 = listOf("A1", "A2", "A3")
        val list2 = listOf("B1", "B2", "B3", "B4")
        val expected = listOf("A1B1", "A2B2", "A3B3")

        val flowA = Example2.getFlowA(list1)
        val flowB = Example2.getFlowB(list2)
        val actual = mutableListOf<String>()

        // when
        Example2.getFlowZip(flowA, flowB)
            .collect { actual.add(it) }

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `flowA, flowB의 combine한 결과를 얻을 수 있다`() = runTest {
        // given
        val list1 = listOf("A1", "A2", "A3")
        val list2 = listOf("B1", "B2", "B3", "B4")
        val expected = listOf("A1B3", "A1B4", "A2B4", "A3B4")

        val flowA = Example2.getFlowA(list1)
        val flowB = Example2.getFlowB(list2)
        val actual = mutableListOf<String>()

        // when
        Example2.getFlowCombine(flowA, flowB)
            .collect { actual.add(it) }

        // then
        assertEquals(expected, actual)
    }
}