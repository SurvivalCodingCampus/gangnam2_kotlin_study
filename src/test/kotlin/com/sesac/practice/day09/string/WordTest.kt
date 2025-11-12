package com.sesac.practice.day09.string

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WordTest {
    @Test
    fun `Word를 생성한다`() {
        // given
        val wordString = "word"

        // when
        val word = Word(wordString)

        // then
        assertEquals(wordString, word.word)
    }

    @Test
    fun `Word의 i번째 글자가 모음일 경우 true를 반환한다`() {
        // given
        val vowel = "aeiou"
        val word = Word(vowel)

        for (i in 0..4) {
            // when
            val actual = word.isVowel(i)

            // then
            assertTrue(actual)
        }
    }

    @Test
    fun `Word의 i번째 글자가 모음이 아닐 경우 false를 반환한다`() {
        // given
        val notVowel = "b"
        val word = Word(notVowel)

        // when
        val actual = word.isVowel(0)

        // then
        assertFalse(actual)
    }
}
