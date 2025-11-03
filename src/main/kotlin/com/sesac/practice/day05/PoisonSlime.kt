package com.sesac.practice.day05

class PoisonSlime(
    suffix: String,
    poisonCount: Int = POISON_COUNT,
) : Slime(suffix) {
    var poisonCount = poisonCount
        private set

    override fun attack(hero: Hero) {
        super.attack(hero)

        if (cannotPoisonAttack()) {
            return
        }

        poisonAttack(hero)
    }

    private fun cannotPoisonAttack(): Boolean {
        return poisonCount <= 0
    }

    private fun poisonAttack(hero: Hero) {
        println("추가로, 독 포자를 살포했다!")
        poisonCount--
        hero.hp -= POISON_DAMAGE
        println("$POISON_DAMAGE 포인트의 데미지")
    }

    companion object {
        const val POISON_COUNT = 5
        const val POISON_DAMAGE = Hero.MAX_HP / 5
    }
}
