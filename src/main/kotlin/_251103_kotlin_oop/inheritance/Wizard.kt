package _251103_kotlin_oop.inheritance

import _251031_kotlin_oop.encapsulation.MINIMUM_NAME_LENGTH
import _251031_kotlin_oop.encapsulation.Wand

const val WIZARD_MINIMUM_MP = 100

class Wizard(
    var name: String,
    var hp: Int,
    var wand: Wand?,
) {
    var mp: Int = WIZARD_MINIMUM_MP

    init {
        if (name.isEmpty() || name.length < MINIMUM_NAME_LENGTH) {
            throw IllegalArgumentException("마법사의 이름은 3글자 이상이어야 합니다.")
        }
        if (mp < WIZARD_MINIMUM_MP) {
            throw IllegalArgumentException("마법사의 MP는 ${WIZARD_MINIMUM_MP}이상이어야 합니다.")
        }

    }

    fun attacked(damage: Int) {//공격 받은것
        if (hp - damage < 0) {
            hp = 0
        } else {
            hp -= damage
        }
    }

}
