package com.survivalcoding.kotlinstudy.`05_inheritance`

// 연습문제 5. GreatWizard 클래스 작성
class GreatWizard(
    name: String,
    mp: Int = 150,
    hp: Int,
    wand: Wand?,
) : Wizard(name, mp, hp, wand) {

    // super 를 사용해보기 위해서 재정의
    override val mpCost = 5
    override val hpRecovery = 25

    override fun heal(hero: Hero) {
        super.heal(hero)  // super를 사용해보기

        // 이건 새로운 superHeal 메서드
        fun superHeal(hero: Hero) {
            val mpCost = 50
            if (mp < mpCost) {
                println("마나가 부족합니다")
            } else {
                hero.hp = hero.maxHp
                mp -= mpCost
                println("슈퍼 힐을 시전했습니다. 대상 HP: ${hero.hp}")
            }
        }
    }
}
