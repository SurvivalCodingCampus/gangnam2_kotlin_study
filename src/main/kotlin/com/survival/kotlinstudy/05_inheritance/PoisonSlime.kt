package com.survival.kotlinstudy.`05_inheritance`

import com.survival.kotlinstudy.`02_instance_class`.Hero


class PoisonSlime(
    suffix: String
) : Slime(suffix) {
    var poisonCount = 5

    override fun attack(hero: Hero) {
        super.attack(hero)

        if (poisonCount > 0) {
            println("추가로, 독 포자를 살포했다!")
            val damage = (hero.maxHp * 0.2).toInt()
            hero.hp -= damage
            println("$damage 포인트의 데미지")
            poisonCount--
        }
    }
}

fun main() {
    val poisonSlime = PoisonSlime("A")
    val hero = Hero(name = "홍길동", hp = 100)

    poisonSlime.attack(hero)

}