package com.neouul.sesac.`04-inheritance`

class PoisonSlime(
    suffix: String,
) : Slime(suffix) {
    companion object {
        const val POISON_NUMBER = 5
    }

    var poisonCount = POISON_NUMBER

    override fun attack(hero: Hero) {
        super.attack(hero)

        if (poisonCount != 0) {
            println("추가로, 슬라임 $suffix 가 독 포자를 살포했다!")
            val poisonDamage = hero.maxHp / 5
            hero.hp -= poisonDamage
            println("$poisonDamage 포인트의 데미지")
            poisonCount--
        }
    }
}