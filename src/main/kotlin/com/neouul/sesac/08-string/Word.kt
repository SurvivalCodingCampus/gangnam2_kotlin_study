package com.neouul.sesac.`08-string`

class Word(var word: String) {

    fun isVowel(index: Int): Boolean {
        // char형이라서 string 활용하는 것으로 수정
//        return when(word[index]){
//            'a', 'e', 'i', 'o', 'u' -> true
//            else -> false
//        }

        // 대소문자 구분 없애기
        val lowerCaseWord = word.lowercase()
        val target = lowerCaseWord.substring(index, index + 1)
        return target == "a" || target == "e" || target == "i" || target == "u" || target == "o"
    }

    fun isConsonant(index: Int): Boolean {
        // 모음이라면 false 리턴
        if (isVowel(index)) return false

        // 문자라면 true, 아니라면(문장부호 등) false 리턴
        val target = word.substring(index, index + 1)
        return target.single().isLetter()   // Returns true if this character is a letter
    }
}