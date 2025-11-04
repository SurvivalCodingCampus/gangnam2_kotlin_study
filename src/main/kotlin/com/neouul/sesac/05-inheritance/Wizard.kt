package com.neouul.sesac.`05-inheritance`

open class Wizard(
    name: String,
    hp: Int,
    var wand: Wand?,
) {
    companion object {
        const val MAX_MP = 100
        const val MIN_NAME_LENGTH = 3

        // heal 스킬 관련
        const val HEAL_HP = 20
        const val HEAL_MP = 10
    }

    init {
        checkName(name)
        require(hp >= 0) { "invalid value: HP의 입력은 0 이상이어야 합니다" }
    }

    var name: String = name
        set(value) {
            checkName(value)
            field = value
        }

    var mp: Int = MAX_MP
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

    // 연습문제 4
    open fun heal(hero: Hero) {
//        checkHeal(HEAL_HP, HEAL_MP, hero)

        if (mp >= HEAL_MP) {
            hero.hp += HEAL_HP
            mp -= HEAL_MP
            println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
        } else {
            println("마나가 부족합니다")
        }
    }

//    protected fun checkHeal(healHp: Int, healMp: Int, hero: Hero) {
//        if (mp >= healMp) {
//            hero.hp += healHp
//            mp -= healMp
//            if (this is GreatWizard) {
//                print("슈퍼 ")
//            }
//            println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
//        } else {
//            println("마나가 부족합니다")
//        }
//    }
}