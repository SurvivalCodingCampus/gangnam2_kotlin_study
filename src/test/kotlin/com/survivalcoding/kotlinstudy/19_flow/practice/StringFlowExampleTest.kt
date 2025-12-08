package com.survivalcoding.kotlinstudy.`19_flow`.practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringFlowExampleTest {

    @Test
    fun `zip은 두 Flow의 데이터를 1대1로 짝지어야 한다`() = runTest {
        val input1 = flowOf("A", "B", "C")
        val input2 = flowOf("1", "2")
        val expected = listOf("A1", "B2")

        val example = StringFlowExample(input1, input2)

        val result = example.getZippedFlow().toList()

        assertEquals(expected, result)
    }

    @Test
    fun `combine은 각 Flow의 최신 값을 조합해야 한다`() = runTest {
        val input1 = flow {
            emit("A")
            delay(100)
            emit("B")
        }
        val input2 = flow {
            delay(50)
            emit("1")
            delay(100)
            emit("2")
        }

        val expected = listOf("A1", "B1", "B2")
        val example = StringFlowExample(input1, input2)

        val result = example.getCombinedFlow().toList()

        assertEquals(expected, result)
    }
}