package com.survivaalcoding.kotlinstudy.`09_generic_enum_string`.example

class Word(var word: String) {
    fun isVowel(index: Int): Boolean {
        if (index < 0 || index >= word.length) {
            throw IllegalArgumentException("index는 0부터 전체 단어 길이보다 하나 작아야 합니다.")
        }

        return word[index].lowercase() in VOWEL
    }

    companion object {
        const val VOWEL = "aeiou"
    }
}