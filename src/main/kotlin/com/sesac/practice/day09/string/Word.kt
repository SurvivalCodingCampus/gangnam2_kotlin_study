package com.sesac.practice.day09.string

class Word(var word: String) {
    fun isVowel(index: Int): Boolean {
        if (index < 0 || index >= word.length) {
            return false
        }

        val text = word.substring(index, index + 1).lowercase()

        return when (text) {
            in VOWELS -> true
            else -> false
        }
    }

    fun isConsonant(index: Int): Boolean {
        return !isVowel(index)
    }

    companion object {
        val VOWELS = listOf("a", "e", "i", "o", "u")
    }
}
