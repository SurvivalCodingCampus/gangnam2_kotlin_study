package com.survivaalcoding.kotlinstudy.`18_flow`.example

import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

class Example3Test {

    @Test
    fun `dispatcherIO에서 동작하는 flow를 얻는다`() = runTest {
        // given
        var actual = ""
        val expected = "데이터 로딩 중"
        val dispatcherFlow = Example3.dispatcherFlow()

        // when
        dispatcherFlow.collect { actual = it }

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `사용자 키보드 입력된 값의 flow를 얻는다`() = runTest {
        // given
        val expected = listOf("a", "ab", "abc", "abcd", "abcde")
        val keyboardInputFlow = Example3.getKeyboardInputFlow(expected)

        val actual = mutableListOf<String>()

        // when
        keyboardInputFlow.collect { actual.add(it) }

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `사용자 키보드 입력된 값의 debounce 300인 flow를 얻는다`() = runTest {
        // given
        val debounce = 300L
        val expected = listOf("abcde")

        val keyboardInputs = listOf("a", "ab", "abc", "abcd", "abcde")
        val debounceFlow = Example3.getDebouncedFlow(keyboardInputs, debounce)

        val actual = mutableListOf<String>()

        // when
        debounceFlow.collect { actual.add(it) }

        // then
        assertEquals(expected, actual)
    }
}