package com.survivalcoding.kotlinstudy.`10_string`

class Word(var word: String) {
    private val vowelList = listOf("a", "e", "i", "o", "u")

    // 연습문제 1. isVowel 함수 완성
    fun isVowel(i: Int): Boolean {
        val char = word.substring(i, i + 1).lowercase()
        return char in vowelList
    }

    // 연습문제 2. isConsonant 함수 완성
    fun isConsonant(i: Int): Boolean {
        val char = word.substring(i, i + 1).lowercase()
        return char !in vowelList
    }
}


fun main() {
    val w = Word("APPLE")
    println(w.isVowel(0))   // true
    println(w.isConsonant(0))   // false
}