package com.survival.kotlinstudy.flow

import app.cash.turbine.test
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals


class FlowTest {

    @Test
    fun `짝수 필터링 후 10을 곱한 결과 테스트`() = runTest {
        val expectedList = listOf(20, 40)
        val resultFlow = flow1()
            .filter { it % 2 == 0 }
            .map { it * 10 }


        resultFlow.test {
            assertEquals(expectedList[0], awaitItem())
            assertEquals(expectedList[1], awaitItem())

            awaitComplete()
        }

    }
}