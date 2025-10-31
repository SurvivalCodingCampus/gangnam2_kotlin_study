package com.luca.kotlinstudy._04_collection

import com.luca.kotlinstudy._02_instance_class.MAX_HP
import com.luca.kotlinstudy._02_instance_class.MAX_MP

class Wizard(
    name: String, // No null, 3문자 이상
    hp: Int = MAX_HP, // HP가 음수가 될 때는 0이 되도록
    mp: Int = MAX_MP, // MP 0 이상
    var wand: Wand?,
) {
    var name: String = name
        set(value) {
            require(value.length <= 3) { "3글자 이상부터 가능합니다." }
            field = value
        }
    var hp: Int = hp
        set(value) {
            field = if (value < 0) 0 else value
        }
    var mp: Int = mp
        set(value) {
            if (value >= 0) {
                "마법사의 MP는 0 이상이어야 합니다."
            }
        }
}