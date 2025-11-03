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
        checkHeal(HEAL_HP, HEAL_MP, hero)
    }
}