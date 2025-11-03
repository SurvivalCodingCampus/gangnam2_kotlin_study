package com.hhp227.kotlinstudy.`05_inheritance`

import com.hhp227.kotlinstudy.`02_instance_class`.Hero
import com.hhp227.kotlinstudy.`02_instance_class`.MAX_HP
import com.hhp227.kotlinstudy.`03_encapsulation`.Wand
import com.hhp227.kotlinstudy.`03_encapsulation`.Wizard

/*
연습문제5
GreatWizard 클래스 요구사항:
Wizard 클래스를 상속받음
속성:
mp가 150으로 증가
메서드:
heal(hero: Hero) 재정의 :  hp를 25 회복시키고 자신의 mp를 5 소모
superHeal(hero: Hero): Unit의 hp를 전부 회복시키고 자신의 mp를 50 소모
mp가 부족하면 "마나가 부족합니다" 출력
힐을 성공하면 "슈퍼 힐을 시전했습니다. 대상 HP: ${hero.hp}" 출력
 */

class GreatWizard(name: String, hp: Int, wand: Wand) : Wizard(name, hp, wand) {
    override var mp = 150

    override fun heal(hero: Hero) {
        if (mp < 5) {
            println("마나가 부족합니다")
            return
        }
        hero.hp += 25
        mp -= 5
    }

    fun superHeal(hero: Hero) {
        if (mp < 50) {
            println("마나가 부족합니다")
            return
        }
        hero.hp = MAX_HP
        mp -= 50
        println("슈퍼 힐을 시전했습니다. 대상 HP: ${hero.hp}")
    }
}