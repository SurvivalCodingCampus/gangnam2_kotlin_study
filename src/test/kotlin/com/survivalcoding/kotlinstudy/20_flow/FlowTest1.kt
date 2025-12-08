package com.survivalcoding.kotlinstudy.`20_flow`

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class FlowTest1 {

    @Test
    fun `flow 테스트 -  짝수 10배`() = runTest {
        // given
        val input = listOf(1, 2, 3, 4, 5)

        // when
        val expected = input.filter { it % 2 == 0 }.map { it * 10 }

        val result = flow {
            for (i in 1..5) {
                emit(i)
            }
        }
            .filter { it % 2 == 0 }
            .map { it * 10 }
            .toList()

        // then
        assertEquals(expected, result)
    }

}