package com.neouul.sesac.`03-encapsulation`

class Wizard(
    name: String,
    hp: Int,
    var wand: Wand?,
) {
    init {
        checkName(name)
        require(hp >= 0) { "invalid value: HP의 입력은 0 이상이어야 합니다" }
    }

    var name: String = name
        set(value) {
            checkName(value)
            field = value
        }

    var mp: Int = MAX_WIZARD_MP
        set(value) {
            require(value >= 0) { "invalid value: MP는 0 이상이어야 합니다" }
            field = value
        }

    var hp: Int = hp
        set(value) {
            field = if (value < 0) 0 else value
        }

    private fun checkName(value: String) =
        require(value.length >= MIN_NAME_LENGTH) { "invalid value: 이름은 ${MIN_NAME_LENGTH}자 이상이어야 합니다" }

    fun fireball() {

    }
}