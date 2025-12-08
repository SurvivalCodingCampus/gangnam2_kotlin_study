package com.survivalcoding.kotlinstudy.`20_flow`

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class FlowTest2 {
    val listA = listOf("A1", "A2", "A3")
    val listB = listOf("B1", "B2", "B3", "B4")
    val flowA = getFlowA(listA)
    val flowB = getFlowB(listB)

    @Test
    fun `ZIP 테스트 - 짧은 Flow 기준 방출`() = runTest {
        // given
        val flowA = getFlowA(listA)
        val flowB = getFlowB(listB)
        val expected = listOf("A1 - B1", "A2 - B2", "A3 - B3")

        // when
        val result = getZip(flowA, flowB).toList()

        // then
        assertEquals(expected, result)

    }

    @Test
    fun `COMBINE 테스트 - 최신 조합 방출`() = runBlocking {
        // given
        val flowA = getFlowA(listA)
        val flowB = getFlowB(listB)
        val expected = listOf(
            "A1 - B2",
            "A1 - B3",
            "A1 - B4",
            "A2 - B4",
            "A3 - B4"
        )

        // when
        val result = getCombine(flowA, flowB).toList()

        // then
        assertEquals(expected, result)
    }
}