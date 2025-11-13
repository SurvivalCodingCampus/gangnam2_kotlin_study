package com.survivalcoding.kotlinstudy.`10_string`.practice

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class WordTest {
    @Test
    fun `i번째 글자가 모음인지 확인`() {
        val word = Word("apple")
        val index1 = 4
        val index2 = 1

        val result1 = word.isVowel(index1)
        val result2 = word.isVowel(index2)

        assertEquals(result1, true)
        assertEquals(result2, false)
    }

    @Test
    fun `범위를 벗어나면 오류가 나오는지 확인`() {
        val word = Word("apple")
        val index1 = 5
        val index2 = -1

        assertFailsWith<IndexOutOfBoundsException> {
            word.isVowel(index1)
        }

        assertFailsWith<IndexOutOfBoundsException> {
            word.isVowel(index2)
        }
    }

    @Test
    fun `i번째 글자가 자음인지 확인`() {
        val word = Word("apple")
        val index1 = 1
        val index2 = 3

        val result1 = word.isConsonant(index1)
        val result2 = word.isConsonant(index2)

        assertEquals(result1, true)
        assertEquals(result2, true)
    }
}