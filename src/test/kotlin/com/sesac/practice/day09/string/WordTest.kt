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
    fun `isVowel() 호출시 i번째 글자가 모음일 경우 true를 반환한다`() {
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
    fun `isVowel() 호출시 i번째 글자가 모음이 아닐 경우 false를 반환한다`() {
        // given
        val notVowel = "b"
        val word = Word(notVowel)

        // when
        val actual = word.isVowel(0)

        // then
        assertFalse(actual)
    }

    @Test
    fun `isConsonant() 호출시 i번째 글자가 자음일 경우 true를 반환한다`() {
        // given
        val consonant = "b"
        val word = Word(consonant)

        // when
        val actual = word.isConsonant(0)

        // then
        assertTrue(actual)
    }

    @Test
    fun `isConsonant() 호출시 i번째 글자가 자음이 아닐 경우 false를 반환한다`() {
        // given
        val notConsonant = "aeiou"
        val word = Word(notConsonant)

        for (i in 0..4) {
            // when
            val actual = word.isConsonant(i)

            // then
            assertFalse(actual)
        }
    }
}
