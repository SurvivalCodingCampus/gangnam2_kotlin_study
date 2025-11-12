package com.survivalcoding.kotlinstudy.`10_string`

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WordTest {
    companion object {
        private const val upperW = "APPLE"
        private const val lowerW = "apple"
        private const val mixedW = "a1b!c"   // 알파벳 + 숫자 + 특수문자
        private const val korean = "사과"
        private const val blank = ""
    }

    @Test
    fun `모음 검사 성공`() {
        // given
        val upperWord = Word(upperW)
        val lowerWord = Word(lowerW)

        // then
        assertTrue(upperWord.isVowel(0))
        assertFalse(upperWord.isVowel(1))
        assertTrue(lowerWord.isVowel(0))
        assertFalse(lowerWord.isVowel(1))
    }

    @Test
    fun `모음 검사 false - 인덱스 초과`() {
        // given
        val word = Word(lowerW)

        // when
        val result = word.isVowel(10)

        // then
        assertFalse(result)
    }

    @Test
    fun `모음 검사 false - 알파벳 이외에 다른 글자`() {
        // given
        val word = Word(mixedW)

        // then
        assertTrue(word.isVowel(0))
        assertFalse(word.isVowel(1))
        assertFalse(word.isVowel(3))
    }

    @Test
    fun `모음 검사 false - 한글 문자열`() {
        // given
        val word = Word(korean)

        // then
        assertFalse(word.isVowel(0))
        assertFalse(word.isVowel(1))
    }

    @Test
    fun `모음 검사 false - 빈 문자열`() {
        // given
        val word = Word(blank)

        // then
        assertFalse(word.isVowel(0))
    }

    @Test
    fun `자음 검사 성공`() {
        // given
        val upperWord = Word(upperW)
        val lowerWord = Word(lowerW)

        // then
        assertFalse(upperWord.isConsonant(0))
        assertTrue(upperWord.isConsonant(1))
        assertFalse(lowerWord.isConsonant(0))
        assertTrue(lowerWord.isConsonant(1))
    }

    @Test
    fun `자음 검사 false - 알파벳 이외에 다른 글자`() {
        // given
        val word = Word(mixedW)

        // then
        assertFalse(word.isConsonant(1))
        assertFalse(word.isConsonant(3))
    }

    @Test
    fun `자음 검사 false - 한글 문자열`() {
        // given
        val word = Word(korean)

        // then
        assertFalse(word.isConsonant(0))
        assertFalse(word.isConsonant(1))
    }

    @Test
    fun `자음 검사 false - 인덱스 초과`() {
        // given
        val word = Word(lowerW)

        // when
        val result = word.isConsonant(10)

        // then
        assertFalse(result)
    }

    @Test
    fun `자음 검사 false - 빈 문자열`() {
        // given
        val word = Word(blank)

        //then
        assertFalse(word.isConsonant(0))
    }
}
