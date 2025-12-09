package com.sesac.practice.day18

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class QuizTest {

    @Test
    fun `연습문제 1`() = runTest {
        // given
        val flow = (1..5).asFlow()
            .onEach { delay(100) }
            .filter { it % 2 == 0 }
            .map { it * 10 }

        // when
        val result = flow
            .onEach { println(it) }
            .toList()

        // then
        assertEquals(listOf(20, 40), result)
    }

    @Test
    fun `연습문제 2`() = runTest {
        // given
        val flowA = flowOf("A1", "A2", "A3").onEach { delay(300) }
        val flowB = flowOf("B1", "B2", "B3", "B4").onEach { delay(100) }

        // when
        val zip = flowA.zip(flowB) { a, b -> "$a$b" }
            .onEach { println(it) }
            .toList()
        val combine = flowA.combine(flowB) { a, b -> "$a$b" }
            .onEach { println(it) }
            .toList()

        // then
        assertEquals(listOf("A1B1", "A2B2", "A3B3"), zip)
        assertEquals(listOf("A1B3", "A1B4", "A2B4", "A3B4"), combine)
    }

    @Test
    fun `연습문제 3`() = runTest {
        // given
        val flow = flow {
            emit("데이터 로딩중")
        }.flowOn(Dispatchers.IO)

        // when
        val result1 = flow
            .onEach { println(it) }
            .toList()

        val result2 = flow.flowOn(Dispatchers.Default)
            .onEach { println(it) }
            .toList()

        val result3 = flow {
            emit("A")
            delay(100)
            emit("B")
            delay(200)
            emit("C")
            delay(300)
            emit("D")
            delay(400)
            emit("E")
        }.debounce(300)
            .onEach { println(it) }
            .toList()

        // then
        assertEquals(listOf("데이터 로딩중"), result1)
        assertEquals(listOf("데이터 로딩중"), result2)

        assertEquals(listOf("D", "E"), result3)
    }
}
