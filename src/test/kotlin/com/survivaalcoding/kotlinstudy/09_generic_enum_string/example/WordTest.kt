package com.survivaalcoding.kotlinstudy.`09_generic_enum_string`.example

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class WordTest {
    @Test
    fun `Word 인스턴스를 생성할 수 있다`() {
        // given
        val word = "Hello Kotlin"

        // when
        val actual = Word(word)

        // then
        assertThat(actual).isNotNull
        assertThat(actual.word).isEqualTo(word)
    }

    @Test
    fun `apple의 0번째 문자는 모음이다`() {
        // given
        val index = 0
        val apple = "apple"
        val word = Word(apple)

        // when
        val actual = word.isVowel(index)

        // then
        assertThat(actual).isTrue
    }

    @Test
    fun `apple의 2번째 문자는 모음이 아니다`() {
        // given
        val index = 2
        val apple = "apple"
        val word = Word(apple)

        // when
        val actual = word.isVowel(index)

        // then
        assertThat(actual).isFalse
    }

    @Test
    fun `apple의 마지막 인덱스 문자는 모음이다`() {
        // given
        val apple = "apple"
        val index = apple.length - 1
        val word = Word(apple)

        // when
        val actual = word.isVowel(index)

        // then
        assertThat(actual).isTrue
    }

    @Test
    fun `aeiou는 모두 모음이다`() {
        // given
        val aeiou = "aeiou"
        val word = Word(aeiou)

        // when
        val actual = (0 until aeiou.length).map { word.isVowel(it) }

        // then
        assertThat(actual.all { it }).isTrue
    }

    @Test
    fun `bdjpv는 모두 모음이 아니다`() {
        // given
        val bdjpv = "bdjpv"
        val word = Word(bdjpv)

        // when
        val actual = (0 until bdjpv.length).map { word.isVowel(it) }

        // then
        assertThat(actual.all { it }).isFalse
    }

    @Test
    fun `인덱스 값이 음수이면 예외가 발생한다`() {
        // given
        val any = "any"
        val negative = -1

        val word = Word(any)

        // when
        // then
        assertThatThrownBy { word.isVowel(negative) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `인덱스 값이 문자열 길이와 같으면 예외가 발생한다`() {
        // given
        val any = "any"
        val wordLength = any.length

        val word = Word(any)

        // when
        // then
        assertThatThrownBy { word.isVowel(wordLength) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `인덱스 값이 문자열 길이보다 크면 예외가 발생한다`() {
        // given
        val any = "any"
        val wordLength = any.length + 1

        val word = Word(any)

        // when
        // then
        assertThatThrownBy { word.isVowel(wordLength) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `consonant의 0번째 문자는 자음이다`() {
        // given
        val index = 0
        val consonant = "consonant"
        val word = Word(consonant)

        // when
        val actual = word.isConsonant(index)

        // then
        assertThat(actual).isTrue
    }

    @Test
    fun `consonant의 1번째 문자는 모음이다`() {
        // given
        val index = 1
        val consonant = "consonant"
        val word = Word(consonant)

        // when
        val actual = word.isConsonant(index)

        // then
        assertThat(actual).isFalse
    }

    @Test
    fun `consonant의 마지막 인덱스 문자는 자음이다`() {
        // given
        val consonant = "consonant"
        val index = consonant.length - 1
        val word = Word(consonant)

        // when
        val actual = word.isConsonant(index)

        // then
        assertThat(actual).isTrue
    }

    @Test
    fun `aeiou는 모두 자음이 아니다`() {
        // given
        val aeiou = "aeiou"
        val word = Word(aeiou)

        // when
        val actual = (0 until aeiou.length).map { word.isConsonant(it) }

        // then
        assertThat(actual.all { it }).isFalse
    }

    @Test
    fun `bdjpv는 모두 자음이다`() {
        // given
        val bdjpv = "bdjpv"
        val word = Word(bdjpv)

        // when
        val actual = (0 until bdjpv.length).map { word.isConsonant(it) }

        // then
        assertThat(actual.all { it }).isTrue
    }

    @Test
    fun `자음인지 알려주는 함수에 인덱스 값을 음수로 전달하면 예외가 발생한다`() {
        // given
        val any = "any"
        val negative = -1

        val word = Word(any)

        // when
        // then
        assertThatThrownBy { word.isConsonant(negative) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `자음인지 알려주는 함수에 인덱스 값을 문자열 길이와 같은 값으로 전달하면 예외가 발생한다`() {
        // given
        val any = "any"
        val wordLength = any.length

        val word = Word(any)

        // when
        // then
        assertThatThrownBy { word.isConsonant(wordLength) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `자음인지 알려주는 함수에 인덱스 값을 문자열 길이보다 큰 값을 전달하면 예외가 발생한다`() {
        // given
        val any = "any"
        val wordLength = any.length + 1

        val word = Word(any)

        // when
        // then
        assertThatThrownBy { word.isConsonant(wordLength) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}