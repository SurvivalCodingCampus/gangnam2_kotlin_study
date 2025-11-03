package com.neouul.sesac.`05-inheritance`

class SuperHero(
    name: String,
    hp: Int,
    var sword: Sword?,
) : Hero(name, hp) {
    companion object{
        const val FLYING_DAMAGE = 5
    }

    var isFlying: Boolean = false
        set(value) {
            field = value
            if (value) {
                println("$name 이 날개를 펼쳤다")
            } else {
                println("$name 이 날개를 접었다")
            }
        }

    override fun attack(slime: Slime) {
        super.attack(slime)

        if (isFlying) {
            println("$name 이 $slime 을 공격했다")
            slime.hp -= FLYING_DAMAGE
            println("$FLYING_DAMAGE 포인트의 추가 피해를 입혔다")
        }
    }

    override fun run() {
        println("$name 이 퇴각했다")
    }
}