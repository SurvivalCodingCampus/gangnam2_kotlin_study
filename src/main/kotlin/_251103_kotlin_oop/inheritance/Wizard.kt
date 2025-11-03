package _251103_kotlin_oop.inheritance

import _251030_kotlin_oop.MAX_HP
import _251031_kotlin_oop.encapsulation.MINIMUM_NAME_LENGTH
import _251031_kotlin_oop.encapsulation.Wand

const val WIZARD_MINIMUM_MP = 100 //마법사 최소 mp
const val WIZARD_HEAL_REQUIRED_MP = 10 //heal 메서드 필요 mp
const val WIZARD_HEAL_TREAT_HP = 20 //heal 메서드가 회복시키는 hp

open class Wizard(
    var name: String,
    var hp: Int,
    var wand: Wand?,
) {
    open var mp: Int = WIZARD_MINIMUM_MP
        set(value) {
            if (value < 0) {
                throw IllegalArgumentException("마법사의 MP는 0이상이어야 합니다.")
            }
            field = value
        }

    init {
        if (name.isEmpty() || name.length < MINIMUM_NAME_LENGTH) {
            throw IllegalArgumentException("마법사의 이름은 3글자 이상이어야 합니다.")
        }
        require(mp >= WIZARD_MINIMUM_MP) {
            "마법사의 MP는 ${WIZARD_MINIMUM_MP}이상이어야 합니다.}"
        }


    }

    fun attacked(damage: Int) {//공격 받은것
        if (hp - damage < 0) {
            hp = 0
        } else {
            hp -= damage
        }
    }

    open fun heal(hero: Hero) {
        if (mp >= WIZARD_HEAL_REQUIRED_MP) {
            mp -= WIZARD_HEAL_REQUIRED_MP
            if (hero.hp + WIZARD_HEAL_TREAT_HP > MAX_HP) {
                hero.hp = MAX_HP
            } else {
                hero.hp += WIZARD_HEAL_TREAT_HP
            }
            println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
        } else {
            println("마나가 부족합니다.")
        }
    }

}
