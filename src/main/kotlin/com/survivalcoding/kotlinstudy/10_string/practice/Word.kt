package com.survivalcoding.kotlinstudy.`10_string`.practice

/*
1번.

i 번째 글자가 모음인지 알려주는 isVowel() 메서드를 완성하시오
영어에서의 모음은 a, e, i, o, u 다섯가지이다
*/

/*
2번.

i 번째 글자가 자음인지 알려주는 isConsonant() 함수를 수정하시오
*/

class Word(var word: String) {
    private val vowelString = "a e i o u"

    fun isVowel(i: Int): Boolean {
        if (i < 0 || i > word.length - 1) {
            throw IndexOutOfBoundsException("범위를 벗어났습니다.")
        }

        return vowelString.contains(word.substring(i, i + 1))
    }

    fun isConsonant(i: Int): Boolean {
        if (i < 0 || i > word.length - 1) {
            throw IndexOutOfBoundsException("범위를 벗어났습니다.")
        }

        return !vowelString.contains(word.substring(i, i + 1))
    }
}