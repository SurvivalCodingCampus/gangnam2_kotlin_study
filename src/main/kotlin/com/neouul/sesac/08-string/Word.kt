package com.neouul.sesac.`08-string`

class Word(var word: String) {

    fun isVowel(index: Int): Boolean {
        // char형이라서 string 활용하는 것으로 수정
//        return when(word[index]){
//            'a', 'e', 'i', 'o', 'u' -> true
//            else -> false
//        }
        val target = word.substring(index, index + 1)
        return target == "a" || target == "e" || target == "i" || target == "u" || target == "o"
    }

    fun isConsonant(index: Int): Boolean {
        return !isVowel(index)
    }
}