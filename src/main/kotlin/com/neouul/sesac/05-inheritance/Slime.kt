package com.neouul.sesac.`05-inheritance`

class Slime(val suffix: String) {
    companion object{
        const val DAMAGE = 10
    }
    var hp = 50

    fun attack(hero: Hero){
        println("슬라임 $suffix 가 공격했다")
        println("${DAMAGE}의 데미지")
        hero.hp -= DAMAGE
    }
}