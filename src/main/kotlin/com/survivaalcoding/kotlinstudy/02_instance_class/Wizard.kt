package com.survivaalcoding.kotlinstudy.`02_instance_class`

class Wizard(
    var name: String,
    var hp: Int
) {
    fun heal(hero: Hero) {
        hero.hp += 10
        println("${hero.name}의 hp를 10 회복했습니다.")
    }
}