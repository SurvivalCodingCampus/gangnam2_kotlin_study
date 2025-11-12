package com.ezlevup.my.day251112.exercise

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WordTest {
    @Test
    fun `Word 생성자 생성`() {
        // giver
        val txt = "lee is apple"
        val word = Word(txt)

        // when & then
        assertEquals(txt, word.word)
    }

    @Test
    fun `Word isVowel 성공 확인`() {
        // giver
        val txt = "lee is apple"
        val word = Word(txt)

        // when
        val i: Int = 1
        val result: Boolean = word.isVowel(i)

        // then
        assertTrue(result)
    }

    @Test
    fun `Word isVowel 실패 확인`() {
        // giver
        val txt = "lee is apple"
        val word = Word(txt)

        // when
        val i: Int = 0
        val result: Boolean = word.isVowel(i)

        // then
        assertFalse(result)
    }

    @Test
    fun `Word isVowel i범위 over`() {
        // giver
        val txt = "lee is apple"
        val word = Word(txt)

        // when
        val i: Int = txt.length + 100
        val result: Boolean = word.isVowel(i)

        // then
        assertFalse(result)
    }

    @Test
    fun `Word isVowel i범위 음수`() {
        // giver
        val txt = "lee is apple"
        val word = Word(txt)

        // when
        val i: Int = -100
        val result: Boolean = word.isVowel(i)

        // then
        assertFalse(result)
    }

    @Test
    fun `Word isVowel text가 빈값`() {
        // giver
        val txt = ""
        val word = Word(txt)

        // when
        val i: Int = 1
        val result: Boolean = word.isVowel(i)

        // then
        assertFalse(result)
    }
}