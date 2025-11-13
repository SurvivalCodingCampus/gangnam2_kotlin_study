package com.survival.kotlinstudy.`09_string`

class Word(var word: String) {
    private val vowelList = listOf("a", "e", "i", "o", "u")

    fun isVowel(i: Int): Boolean {
        return vowelList.contains(word.substring(i, i + 1).lowercase())
    }

    fun isConsonant(i: Int): Boolean {
        if (!word[i].isLetter()) {
            return false
        }
        return !vowelList.contains(word.substring(i, i + 1).lowercase())
    }
}