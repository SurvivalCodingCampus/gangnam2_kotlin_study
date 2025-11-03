package com.ezlevup.my.exercise

class PoisonSlime(
    suffix: String,
    var poisonCount: Int = PoisonSlime.MAX_POISON_COUNT,
) : Slime(suffix) {
    companion object {
        const val MAX_POISON_COUNT = 5
    }

    override fun attack(hero: Hero) {
        super.attack(hero)
        if (poisonCount > 0) {
            println("추가로, 독 포자를 살포했다!")
            val damage: Int = calculateDamage(hero)
            hero.takeDamage(damage)
            println("$damage 포인트의 데미지")
            poisonCount--
        }

    }

    fun calculateDamage(hero: Hero): Int {
        println("PoisonSlime calculateDamage")
        return (hero.maxHp / 5).toInt()
    }

}

fun main() {
    val poisonSlime = PoisonSlime("A")
    val hero = Hero(name = "lee", hp = 100)

    poisonSlime.attack(hero)
}
