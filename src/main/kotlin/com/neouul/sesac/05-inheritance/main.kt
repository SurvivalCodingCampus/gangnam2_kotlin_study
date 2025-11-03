package com.neouul.sesac.`05-inheritance`

fun main(){
    // 연습문제 4, 5
    val w = Wizard("AAA", 30, null)
    val ww = GreatWizard("BBB", 40, null)
    println(w.mp)
    println(ww.mp)
//    ww.mp = -1

    val hero = Hero("한석봉", 10)
    w.heal(hero)
    ww.heal(hero)
    println("마법사 마나 ${w.mp} / 대마법사 마나 ${ww.mp}")

    // 연습문제 3
    val hero2 = Hero("김", 50)
    val superHero = SuperHero("최", 70, sword = null)
    println(hero2.maxHp)
    println(superHero.maxHp)
    val p = PoisonSlime("A")
    p.attack(hero)
}