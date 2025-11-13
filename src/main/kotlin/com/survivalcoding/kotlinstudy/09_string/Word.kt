package com.survivalcoding.kotlinstudy.`09_string`

class Word(var word: String) {

    fun isVowel(i: Int) = VOWELS.contains(word.substring(i, i + 1))

    fun isConsonant(i: Int) = !isVowel(i)

    companion object {
        const val VOWELS = "aeiouAEIOU"
    }
}