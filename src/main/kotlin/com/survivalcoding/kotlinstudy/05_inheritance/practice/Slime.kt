package com.survivalcoding.kotlinstudy.`05_inheritance`.practice

import com.survivalcoding.kotlinstudy.`02_instance_class`.Hero

open class Slime(
    val suffix: String
) {
    val hp = 50

    open fun attack(hero: Hero){
        println("슬라임 $suffix 가 공격했다")
        println("10의 데미지")
        hero.hp -= 10
    }
}