package com.ezlevup.my.day251112.exercise

val vowel = listOf<String>("a", "e", "i", "o", "u")

class Word(
    var word: String,
) {
    fun isVowel(i: Int): Boolean {
        if (i < 0) {
            return false
        }

        if (word.isEmpty()) {
            return false
        }

        if (word.length < i) {
            return false
        }

        val str = word.lowercase().substring(i, i + 1)
        val result = vowel.contains(str)
        return result
    }
}

fun main() {
    val word = Word("lee is apple")
    println(word.isVowel(-1))
}


