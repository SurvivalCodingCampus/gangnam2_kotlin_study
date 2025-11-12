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
        // isLetter를 썼더니 유니코드에 포함된 모든 문자에 대해서 true를 리턴함
        val targetChar = word.substring(index, index + 1).single()
        return targetChar in 'A'..'Z' || targetChar in 'a'..'z'
    }
}