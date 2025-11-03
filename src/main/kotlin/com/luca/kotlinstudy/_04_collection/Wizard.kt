package com.luca.kotlinstudy._04_collection

import com.luca.kotlinstudy._02_instance_class.MAX_HP
import com.luca.kotlinstudy._02_instance_class.MAX_MP

const val MIN_HP_MP = 0
const val MIN_NAME_LENGTH = 3

class Wizard(
    name: String, // No null, 3문자 이상
    hp: Int = MAX_HP, // HP가 음수가 될 때는 0이 되도록
    mp: Int = MAX_MP, // MP 0 이상
    var wand: Wand? = null,
) {
    var name: String = name
        set(value) {
            require(value.length >= MIN_NAME_LENGTH) { "3글자 이상부터 가능합니다." }
            field = value
        }
    var hp: Int = hp
        set(value) {
            field = if (value < MIN_HP_MP) 0 else value
        }
    var mp: Int = mp
        set(value) {
            require(value >= MIN_HP_MP) { "마법사의 MP는 $MIN_HP_MP 이상이어야 합니다." }
            field = value
        }


    init {
        this.name = name
        this.hp = hp
        this.mp = mp
    }
}