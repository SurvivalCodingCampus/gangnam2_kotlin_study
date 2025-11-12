package com.survivalcoding.kotlinstudy.`10_string`

// 연습문제 1. isVowel 함수 완성
class Word(var word: String) {

    fun isVowel(i: Int): Boolean {
        val char = word.substring(i, i + 1).lowercase()
        val vowelList = listOf("a", "e", "i", "o", "u")
        return char in vowelList
    }
}
