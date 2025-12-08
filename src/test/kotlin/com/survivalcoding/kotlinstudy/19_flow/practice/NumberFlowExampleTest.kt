package com.survivalcoding.kotlinstudy.`19_flow`.practice

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberFlowExampleTest {

    @Test
    fun `짝수를 필터링하고 10을 곱해야 한다`() = runTest {
        val inputFlow = flowOf(1, 2, 3, 4, 5)
        val numberFlowExample = NumberFlowExample(inputFlow)
        val expected = listOf(20, 40)

        val result = numberFlowExample.getProcessedFlow().toList()

        assertEquals(expected, result)
    }
}