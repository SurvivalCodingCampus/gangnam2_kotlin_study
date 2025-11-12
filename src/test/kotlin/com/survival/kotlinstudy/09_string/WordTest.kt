package com.survival.kotlinstudy.`09_string`

import org.junit.Test
import kotlin.test.assertEquals

class WordTest {

    @Test
    fun `마지막 글자가 모음인지 테스트`() {
        // given (준비)
        val text = "Apple"
        val word = Word(text)
        val expected = true
        // when (실행)

        // then (검증)
        assertEquals(expected, word.isVowel(4))
    }

    @Test
    fun `3번째 글자가 자음인지 테스트`() {
        // given (준비)
        val text = "Apple"
        val word = Word(text)
        val expected = true
        // when (실행)

        // then (검증)
        assertEquals(expected, word.isConsonant(2))
    }

    @Test
    fun `글자가 숫자면 함수의 반환이 false 이어야 한다`() {
        // given (준비)
        val text = "12109831"
        val word = Word(text)
        val expected = false
        // when (실행)

        // then (검증)
        assertEquals(expected, word.isConsonant(3))
        assertEquals(expected, word.isVowel(3))
    }

}