package com.survival.kotlinstudy.`09_string`

class Word(var word: String) {

    fun isVowel(i: Int): Boolean {
        return listOf("a","e","i","o","u").contains(word.substring(i, i + 1))
    }
}