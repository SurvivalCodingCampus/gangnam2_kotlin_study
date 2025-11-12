package com.hhp227.kotlinstudy.`09_generic_string`

import kotlin.test.Test
import kotlin.test.assertTrue

class WordTest {
    @Test
    fun `첫번째 글자가 모음인지 테스트`() {
        val fruit = "orange"
        val word = Word(fruit)

        val isBowel = word.isBowel(0)

        assertTrue(isBowel)
    }

    @Test
    fun `세번째 글자가 모음인지 테스트`() {
        val fruit = "grape"
        val word = Word(fruit)

        val isBowel = word.isBowel(2)

        assertTrue(isBowel)
    }

    @Test
    fun `마지막 글자가 모음인지 테스트`() {
        val fruit = "banana"
        val word = Word(fruit)

        val isBowel = word.isBowel(fruit.length - 1)

        assertTrue(isBowel)
    }

    @Test
    fun `첫번째 글자가 자음인지 테스트`() {
        val fruit = "strawberry"
        val word = Word(fruit)

        val isConsonant = word.isConsonant(0)

        assertTrue(isConsonant)
    }

    @Test
    fun `세번째 글자가 자음인지 테스트`() {
        val fruit = "melon"
        val word = Word(fruit)

        val isConsonant = word.isConsonant(2)

        assertTrue(isConsonant)
    }

    @Test
    fun `마지막 글자가 자음인지 테스트`() {
        val fruit = "peach"
        val word = Word(fruit)

        val isConsonant = word.isConsonant(fruit.length - 1)

        assertTrue(isConsonant)
    }
}