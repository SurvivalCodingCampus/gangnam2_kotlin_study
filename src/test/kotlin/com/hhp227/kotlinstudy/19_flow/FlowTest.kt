package com.hhp227.kotlinstudy.`19_flow`

import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class FlowTest {
    @Test
    fun `intFlow_테스트`() = runTest {
        val result = mutableListOf<Int>()
        val expected = listOf(20, 40)

        intFlow.collect {
            result.add(it)
        }
        assertEquals(expected, result)
    }

    @Test
    fun `zipFlow는 쌍으로 된 값을 하나씩 방출해야_하는지 테스트`() = runTest {
        val result = mutableListOf<String>()
        val expected = listOf("A1B1", "A2B2", "A3B3")

        zipFlow.collect {
            result.add(it)
        }
        assertEquals(expected, result)
    }

    @Test
    fun `combineFlow는 두 Flow 모두 적어도 하나의 값을 가진 후에 모든 흐름이 방출될 때마다 방출하는지 테스트`() = runTest {
        val result = mutableListOf<String>()
        val expected = listOf(
            "A1B1",
            "A1B2",
            "A1B3",
            "A2B4",
            "A3B4"
        )

        combineFlow.collect {
            result.add(it)
        }
        assertEquals(expected, result)
    }

    @Test
    fun `flow debounce 테스트`() = runTest {
        val result = mutableListOf<String>()
        val expected = listOf("데이터 로딩 중...", "abcde")

        loadingFlow.collect {
            result.add(it)
        }
        userInputFlow
            .debounce(300)
            .collect {
                result.add(it)
            }
        assertEquals(expected, result)
    }
}