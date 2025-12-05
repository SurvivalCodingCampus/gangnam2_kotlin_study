package com.survival.kotlinstudy.flow

import app.cash.turbine.test
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals


class FlowTest {

    @Test
    fun `짝수 필터링 후 10을 곱한 결과 테스트`() = runTest {
        val expectedList = listOf(20, 40)
        val resultFlow = flow1()

        resultFlow.test {
            assertEquals(expectedList[0], awaitItem())
            assertEquals(expectedList[1], awaitItem())

            awaitComplete()
        }
    }

    @Test
    fun `flowA 와 flowB zip 연산 테스트`() = runTest {
        val expectedList = listOf(
            "A1 - B1", "A2 - B2", "A3 - B3"
        )
        val flowA = flowA()
        val flowB = flowB()

        val zippedFlow = flowA.zip(flowB) { a, b ->
            "$a - $b"
        }

        zippedFlow.test {
            assertEquals(expectedList[0], awaitItem())
            assertEquals(expectedList[1], awaitItem())
            assertEquals(expectedList[2], awaitItem())

            awaitComplete()
        }
    }

    @Test
    fun `flowA 와 flowB combine 연산 테스트`() = runTest {
        val expectedList = listOf(
            "A1 - B2", "A1 - B3", "A2 - B3", "A3 - B3"
        )
        val flowA = flowA()
        val flowB = flowB()

        val combinedFlow = flowA.combine(flowB) { a, b ->
            "$a - $b"
        }

        combinedFlow.test {
            assertEquals(expectedList[0], awaitItem())
            assertEquals(expectedList[1], awaitItem())
            assertEquals(expectedList[2], awaitItem())
            assertEquals(expectedList[3], awaitItem())

            awaitComplete()
        }
    }

}