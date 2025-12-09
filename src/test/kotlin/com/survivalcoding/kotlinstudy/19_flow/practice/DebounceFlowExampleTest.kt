package com.survivalcoding.kotlinstudy.`19_flow`.practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DebounceFlowExampleTest {

    @Test
    fun `300ms 이내에 새로운 값이 오면 이전 값은 무시되어야 한다`() = runTest {
        val input = flow {
            emit("A")
            delay(100)
            emit("B")
            delay(301)
            emit("C")
            delay(301)
            emit("D")
            delay(50)
            emit("E")
            delay(301)
        }

        val expected = listOf("B", "C", "E")

        val example = DebounceFlowExample(input)

        val result = example.getDebouncedFlow().toList()

        assertEquals(expected, result)
    }
}