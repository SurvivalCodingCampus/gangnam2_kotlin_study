package com.survivalcoding.kotlinstudy.`19_flow`.practice


import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DispatcherFlowExampleTest {

    @Test
    fun `Dispatcher를 변경해도 데이터가 정상적으로 수집되어야 한다`() = runTest {
        val input = flowOf("A", "B", "C")
        val expected = listOf("A", "B", "C")

        val example = DispatcherFlowExample(input)

        val result = example.getFlowOnDefault().toList()

        assertEquals(expected, result)
    }

    @Test
    fun `upstream은 Default 스레드 풀에서 실행되어야 한다`() = runTest {
        var capturedThreadName = ""
        val input = flow {
            capturedThreadName = Thread.currentThread().name
            emit("Test")
        }
        val example = DispatcherFlowExample(input)

        example.getFlowOnDefault().toList()

        assertTrue(capturedThreadName.contains("DefaultDispatcher"))
    }
}