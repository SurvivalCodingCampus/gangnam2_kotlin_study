package com.luca.kotlinstudy._10_string

import org.junit.Assert.*
import org.junit.Test

class WordTest {
    @Test
    fun `첫번째 글자가 모음일 때`() {
        val word = Word("apple")
        assertTrue(word.isVowel(0))
    }

    @Test
    fun `대문자 + 첫번째 글자가 모음일 때`() {
        val word = Word("APPLE")
        assertTrue(word.isVowel(0))
    }

    @Test
    fun `두번째 글자가 모음일 때`() {
        val word = Word("kiki")
        assertTrue(word.isVowel(1))
    }

    @Test
    fun `모음 체크 + 첫번째 글자(자음)를 체크할 때 False`() {
        val word = Word("kiki")
        assertFalse(word.isVowel(0))
    }

    @Test
    fun `첫번째 글자가 자음일 때`() {
        val word = Word("luca")
        assertTrue(word.isConsonant(0))
    }

    @Test
    fun `대문자 + 첫번째 글자가 자음일 때`() {
        val word = Word("LUCA")
        assertTrue(word.isConsonant(0))
    }

    @Test
    fun `자음 체크 + 두번째 글자(모음)를 체크할 때 False`() {
        val word = Word("luca")
        assertFalse(word.isConsonant(1))
    }

    @Test
    fun `자음 체크 +숫자를 넣었을 때 False`() {
        val word = Word("1234")
        assertFalse(word.isConsonant(1))
    }
    @Test
    fun `모음 체크 +숫자를 넣었을 때 False`() {
        val word = Word("1234")
        assertFalse(word.isVowel(1))
    }

    @Test
    fun `스페이스 부분을 체크해도 false`(){
        val word = Word("Hello World")
        assertFalse(word.isVowel(5))
        assertFalse(word.isConsonant(5))
    }

    @Test
    fun `인덱스 길이보다 길게 넣으면 false`(){
        val word = Word("LUCA")
        assertFalse(word.isConsonant(5))
        assertFalse(word.isVowel(5))
    }
}