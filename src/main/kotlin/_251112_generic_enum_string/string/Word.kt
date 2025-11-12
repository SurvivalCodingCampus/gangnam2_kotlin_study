package _251112_generic_enum_string.string

class Word(var word: String) {
    fun isVowel(i: Int): Boolean {
        return when (word.substring(i, i + 1)) {
            "a" -> {
                true
            }

            "e" -> {
                true
            }

            "i" -> {
                true
            }

            "o" -> {
                true
            }

            "u" -> {
                true
            }

            else -> {
                false
            }
        }
    }

    fun isConsonant(i: Int): Boolean {
        return !isVowel(i)
    }
}