package _251103_kotlin_oop.inheritance

import _251030_kotlin_oop.MAX_HP

const val POISONCOUNT = 5

class PoisonSlime(
    val name: String,
) : Slime("poison") {
    init {
        if (name.isEmpty()) {
            throw IllegalArgumentException("슬라임 이름을 지정해주세요.")
        }
    }

    var poisonCount = POISONCOUNT
    override fun attack(hero: Hero) {
        super.attack(hero)
        if (poisonCount > 0) {
            println("추가로, 독 포자를 살포했다!")
            val additionalAttack = MAX_HP / 5
            if (additionalAttack < hero.hp) {
                println("hero는 ${additionalAttack}의 데미지를 더 받았다!")
                hero.hp -= additionalAttack
                poisonCount -= 1
            } else {
                println("hero는 ${hero.hp}의 데미지를 더 받았다!")
                hero.hp = 0
                poisonCount -= 1
            }
        }
    }
}