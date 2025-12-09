package com.survivalcoding.kotlinstudy.`20_flow`

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
class FlowTest3 {

    @Test
    fun `loadingFlow - Io, 문자열 방출`() = runTest {
        // given
        val expected = listOf("데이터 로딩 중")

        // when
        val result = loadingFlow().toList()

        // then
        assertEquals(expected, result)
    }

    @Test
    fun `changedFlow`() = runTest {
        // given
        val expected = listOf("Changing Thread : 데이터 로딩 중")

        // when
        val result = changedFlow(loadingFlow()).toList()

        // then
        assertEquals(expected, result)
    }

    @Test
    fun `keyboardInputFlow - 순차적으로 값을 방출`() = runTest {
        // given
        val input = listOf("qwer", "asdf", "zxcv")
        val expected = input

        // when
        val result = keyboardInputFlow(input).toList()

        // then
        assertEquals(expected, result)
    }

    @Test
    fun `debounceKeyboardFlow - 최종 입력값만 방출`() = runTest {
        // given
        val input = listOf("qwer", "asdf", "zxcv", "wewrt", "sdfg")
        val expected = listOf("sdfg")

        // when
        val result = debounceKeyboardFlow(keyboardInputFlow(input)).toList()

        // then
        assertEquals(expected, result)
    }
}
