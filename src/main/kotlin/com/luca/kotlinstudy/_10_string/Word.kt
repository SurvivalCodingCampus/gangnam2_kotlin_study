package com.luca.kotlinstudy._10_string

class Word(var word: String) {

    /*
    i 번째 글자가 모음인지 알려주는 isVowel() 메서드를 완성하시오
    영어에서의 모음은 a, e, i, o, u 다섯가지이다
     */
    fun isVowel(i: Int): Boolean {
        val vowel = listOf("a", "e", "i", "o", "u")

        if (i < 0 || i >= word.length) return false

        val result = word[i].lowercase() in vowel
        //val result2 = vowel[i].contains(word[i].lowercase())
        return result
    }

    //i 번째 글자가 자음인지 알려주는 isConsonant() 함수를 수정하시오
    //    fun isConsonant(i: Int): Boolean {
//        val consonant = listOf("b", "c", "d", "f", "g","h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u","v", "w", "x", "y", "z")
//        val result = word[i].lowercase() in consonant
//        return result
//    }
    fun isConsonant(i: Int): Boolean {
        if (i < 0 || i >= word.length) return false
        val consonant = word[i]
        val result = consonant.isLetter() && !isVowel(i)
        return result
    }
}