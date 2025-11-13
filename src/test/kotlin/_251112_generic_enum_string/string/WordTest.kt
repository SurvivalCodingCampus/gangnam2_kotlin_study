package _251112_generic_enum_string.string

import org.junit.Test
import kotlin.test.assertEquals

class WordTest {
    @Test
    fun `isVowel함수가 잘 동작하는지 테스트`() {
        //given
        val word = Word("a")
        //when
        val result = word.isVowel(0)
        //then
        assertEquals(true, result)
    }

    @Test
    fun `isConsonant함수가 잘 동작하는지 테스트`() {
        //given
        val word = Word("a")
        //when
        val result = word.isConsonant(0)
        //then
        assertEquals(false, result)
    }

    @Test(expected = StringIndexOutOfBoundsException::class)
    fun `글자의 길이를 넘어서는 index를 접근할 경우 터지는지 테스트`() {
        //given
        val word = Word("a")
        //when
        word.isVowel(word.word.length + 1)
        //then
        //터짐

    }

}