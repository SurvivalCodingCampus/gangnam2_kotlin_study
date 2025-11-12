package com.ezlevup.my.day251112.exercise

val vowel = listOf<String>("a", "e", "i", "o", "u")

class Word(
    var word: String,
) {

    fun isValidIndex(i: Int): Boolean {
        return i >= 0 && i < word.length
    }

    fun isVowel(i: Int): Boolean {
        if (isValidIndex(i) == false) {
            return false
        }

        val str = word.lowercase().substring(i, i + 1)
        val result = vowel.contains(str)
        return result
    }

    fun isConsonant(i: Int): Boolean {
        if (isValidIndex(i) == false) {
            return false
        }

        return !isVowel(i)
    }
}

fun main() {
    val word = Word("lee is apple")
    println(word.isVowel(1))
    println(word.isConsonant(1))
    println(word.isConsonant(0))

}


