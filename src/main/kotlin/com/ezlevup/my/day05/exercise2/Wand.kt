package com.ezlevup.my.day05.exercise2

class Wand(
    name: String,
    var power: Double, // 마력
) {
    companion object {
        const val MIN_NAME_LENGTH = 3
        const val MAX_NAME_LENGTH = 10
    }

    var name: String = name
        set(value) {
            require(value.length >= Wand.MIN_NAME_LENGTH) { "이름은 최소 ${Wand.MIN_NAME_LENGTH}자 이상이어야 합니다." }
            require(value.length <= Wand.MAX_NAME_LENGTH) { "이름은 최대 ${Wand.MAX_NAME_LENGTH}자를 넘을 수 없습니다." }
            field = value
        }

    init {
        this.name = name
    }
}

