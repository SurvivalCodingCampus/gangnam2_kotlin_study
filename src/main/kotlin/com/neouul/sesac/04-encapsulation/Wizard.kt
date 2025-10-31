package com.neouul.sesac.`04-encapsulation`

class Wizard(
    name: String,
    hp: Int,
    var wand: Wand?,
) {
    var name: String = name
        set(value) {
            require(value.length >= MIN_NAME_LENGTH) { "invalid value: 이름은 ${MIN_NAME_LENGTH}자 이상이어야 합니다" }
            field = value
        }

    var mp: Int = MAX_WIZARD_MP
        set(value) {
            require(value >= 0) { "invalid value: MP는 0 이상이어야 합니다" }
            field = value
        }

    var hp: Int = hp
        set(value) {
            // TODO: 예외를 던져야 할까??
            field = if (value < 0) 0 else value
        }

    fun fireball(){

    }
}