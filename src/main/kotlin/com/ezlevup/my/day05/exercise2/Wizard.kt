package com.ezlevup.my.day05.exercise2

class Wizard(
    name: String,
    hp: Int,
    var wand: Wand?,
) {
    companion object {
        const val MIN_NAME_LENGTH = 2
        const val MAX_NAME_LENGTH = 10
    }

    var mp: Int = 0
        set(value) {
            require(value >= 0) { "마법사의 MP는 0 이상이어야 한다." }
            field = value
        }

    var name: String = name
        set(value) {
            require(value.length >= Wizard.MIN_NAME_LENGTH) { "이름은 최소 ${Wizard.MIN_NAME_LENGTH}자 이상이어야 합니다." }
            require(value.length <= Wizard.MAX_NAME_LENGTH) { "이름은 최대 ${Wizard.MAX_NAME_LENGTH}자를 넘을 수 없습니다." }
            field = value
        }

    var hp: Int = hp
        set(value) {
            if (value < 0) {
                field = 0
            }
        }

    init {
        this.name = name
        this.hp = hp
    }
}
