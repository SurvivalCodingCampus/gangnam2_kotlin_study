package com.survivaalcoding.kotlinstudy.`04_collections`.example

class Person(val name: String) {
    init {
        if (isBlank()) {
            throw IllegalArgumentException("이름은 빈 문자 혹은 공백일 수 없습니다.")
        }

        if (this.name.length < NAME_LENGTH_RULE) {
            throw IllegalArgumentException("이름은 ${NAME_LENGTH_RULE}자 이상이어야 합니다.")
        }
    }

    private fun isBlank(): Boolean = this.name.isEmpty() || this.name.isBlank()

    companion object {
        const val NAME_LENGTH_RULE = 2
    }
}
