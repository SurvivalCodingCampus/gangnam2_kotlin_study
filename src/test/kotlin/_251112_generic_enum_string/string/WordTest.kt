package _251112_generic_enum_string.string

import org.junit.Test
import kotlin.test.assertEquals

class WordTest {
    @Test
    fun `isVowel함수가 잘 동작하는지 테스트`() {
        //given
        val word = Word("a")
        //then
        assertEquals(true, word.isVowel(0))
    }

    @Test
    fun `isConsonant함수가 잘 동작하는지 테스트`() {
        //given
        val word = Word("a")
        //then
        assertEquals(false, word.isConsonant(0))
    }

}