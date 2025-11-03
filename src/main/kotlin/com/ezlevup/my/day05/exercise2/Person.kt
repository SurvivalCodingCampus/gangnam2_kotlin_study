package com.ezlevup.my.day05.exercise2

class Person(
    val name: String,
    val birthYear: Int,
) {
    companion object {
        const val MIN_NAME_LENGTH = 3
        const val MAX_NAME_LENGTH = 10

        const val MIN_YEAR = 1800
        val MAX_YEAR: Int
            get() = java.time.Year.now().value
    }

    init {
        require(name.length >= Person.MIN_NAME_LENGTH) { "이름은 최소 ${Person.MIN_NAME_LENGTH}자 이상이어야 합니다." }
        require(name.length <= Person.MAX_NAME_LENGTH) { "이름은 최대 ${Person.MAX_NAME_LENGTH}자를 넘을 수 없습니다." }

        require(birthYear.toString().length == 4) { "출생연도는 4자리여야 합니다." }
        require(birthYear in MIN_YEAR..MAX_YEAR) { "출생연도는 $MIN_YEAR~$MAX_YEAR 사이의 4자리 정수여야 합니다." }
    }

    val age: Int
        get() = java.time.Year.now().value - birthYear
}
