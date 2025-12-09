package _251205_flow

import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class Exercise2Test {

    @Test
    fun `원하는 결과대로 나와야한다`() = runTest {
        //given
        val zipResult: MutableList<String> = mutableListOf()
        val combineResult: MutableList<String> = mutableListOf()
        val zipExpectList = listOf("A1B1", "A2B2", "A3B3")
        val combineExpectList = listOf("A1B1", "A1B2", "A1B3", "A2B4", "A3B4")
        //when
        flowA.zip(flowB) { a, b -> "$a$b" }.collect { zipResult.add(it) }
        flowA.combine(flowB) { a, b -> "$a$b" }.collect { combineResult.add(it) }
        //then
        assertEquals(zipExpectList, zipResult)
        assertEquals(combineExpectList, combineResult)
    }

}