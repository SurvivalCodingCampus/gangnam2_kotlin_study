package _251103_kotlin_oop.inheritance

const val POISONCOUNT = 5

class PoisonSlime : Slime("poison") {
    val name: String = ""
    var poisonCount = POISONCOUNT
    override fun attack(hero: Hero) {
        super.attack(hero)
        if (poisonCount > 0) {
            println("추가로, 독 포자를 살포했다!")
            val additionalAttack = hero.hp / 5
            println("hero는 ${additionalAttack}의 데미지를 더 받았다!")
            poisonCount.minus(1)
        }
    }
}