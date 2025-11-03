package com.neouul.sesac.`05-inheritance`

class GreatWizard(
    name: String,
    hp: Int,
    wand: Wand?,
) : Wizard(name, hp, wand) {
    companion object {
        const val MAX_MP = 150

        const val HEAL_HP = 25
        const val HEAL_MP = 5
    }
//    override var mp = 150

    init {
        // mp를 재정의한 것이 아니기 때문에 super 키워드는 필요 없음
        mp = MAX_MP
    }

    override fun heal(hero: Hero) {
//        checkHeal(HEAL_HP, HEAL_MP, hero)

        if (mp >= HEAL_MP) {
            hero.hp += HEAL_HP
            mp -= HEAL_MP
            println("슈퍼 힐을 시전했습니다. 대상 HP: ${hero.hp}")
        } else {
            println("마나가 부족합니다")
        }
    }
}