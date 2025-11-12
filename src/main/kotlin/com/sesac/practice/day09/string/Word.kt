package com.sesac.practice.day09.string

class Word(var word: String) {
    fun isVowel(index: Int): Boolean {
        return when (word.substring(index, index + 1)) {
            in VOWELS -> true
            else -> false
        }
    }

    companion object {
        val VOWELS = listOf("a", "e", "i", "o", "u")
    }
}
