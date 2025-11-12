package com.neouul.sesac.`08-string`

import org.junit.Assert.*
import org.junit.Test

class WordTest {
    @Test
    fun `인스턴스 생성 성공 - String 타입의 인잘을 전달받을 때`() {
        val string = "Hello World!"
        val word = Word(string)

        assertEquals(string, word.word)
    }

    @Test
    fun `isVowel 메서드가 적절한 리턴값을 가지는지`() {
        val string = "HEllo World!"
        val instance = Word(string)

        println("\n===== isVowel 리턴값 확인 =====")
        instance.word.lowercase().forEachIndexed { index, ch ->
            when (ch) {
                'a', 'e', 'i', 'u', 'o' -> {
                    assertTrue(instance.isVowel(index))
                    println("\"${instance.word[index]}\"는 모음입니다: true 리턴")
                }

                else -> {
                    assertFalse(instance.isVowel(index))
                    println("\"${instance.word[index]}\"는 모음이 아닙니다: false 리턴")
                }
            }
        }
    }

    @Test
    fun `isVowel 메서드가 true 반환 - 대문자 모음일 때`() {
        val string = "AIUEO"
        val instance = Word(string)

        instance.word.forEachIndexed { index, ch ->
            assertTrue(instance.isVowel(index))
        }
    }

    @Test
    fun `isVowel 메서드가 true 반환 - 소문자 모음일 때`() {
        val string = "aiueo"
        val instance = Word(string)

        instance.word.forEachIndexed { index, ch ->
            assertTrue(instance.isVowel(index))
        }
    }

    @Test
    fun `isVowel 메서드가 false 반환 - 모음이 아닐 때`() {
        val string = "qw ^%*N-jKl @하이"
        val instance = Word(string)

        instance.word.forEachIndexed { index, ch ->
            assertFalse(instance.isVowel(index))
        }
    }

    @Test
    fun `isConsonant 메서드가 적절한 리턴값을 가지는지`() {
        val string = "HEllo World!다"
        val instance = Word(string)

        println("\n===== isConsonant 리턴값 확인 =====")
        instance.word.lowercase().forEachIndexed { index, ch ->
            when {
                ch in listOf<Char>('a', 'e', 'i', 'u', 'o') -> {
                    assertFalse(instance.isConsonant(index))
                    println("\"${instance.word[index]}\"는 자음이 아닙니다: false 리턴")
                }

                ch.isLetter() -> {
                    assertTrue(instance.isConsonant(index))
                    println("\"${instance.word[index]}\"는 자음입니다: true 리턴")
                }

                else -> {
                    assertFalse(instance.isConsonant(index))
                    println("\"${instance.word[index]}\"는 자음이 아닙니다: false 리턴")
                }
            }
        }

    }

    @Test
    fun `isConsonant 메서드가 true 반환 - 대문자 자음일 때`() {
        val string = "QWRTLKJNC"
        val instance = Word(string)

        instance.word.forEachIndexed { index, ch ->
            assertTrue(instance.isConsonant(index))
        }
    }

    @Test
    fun `isConsonant 메서드가 true 반환 - 소문자 자음일 때`() {
        val string = "zxvbmgfsdyp"
        val instance = Word(string)

        instance.word.forEachIndexed { index, ch ->
            assertTrue(instance.isConsonant(index))
        }
    }

    @Test
    fun `isConsonant 메서드가 false 반환 - 자음이 아닐 때`() {
        val string = "!#$ () aiuEO @하이"
        val instance = Word(string)

        instance.word.forEachIndexed { index, ch ->
            assertFalse(instance.isConsonant(index))
            println("\"${instance.word[index]}\"는 자음이 아닙니다: false 리턴")
        }
    }
}