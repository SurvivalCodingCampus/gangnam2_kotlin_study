package com.neouul.sesac.`05-inheritance`

open class Hero(
    var name: String,
    var hp: Int = MAX_HP,
) {
    companion object {
        const val MAX_HP = 80
        const val DAMAGE = 15
    }

    open val maxHp = MAX_HP

    open fun attack(slime: Slime) {
        println("$name 이 $slime 을 공격했다")
        slime.hp -= DAMAGE
        println("$DAMAGE 포인트의 데미지를 입혔다")

        println("슬라임의 반격을 받았다")
        hp -= Slime.DAMAGE
    }

    open fun run() {
        println("$name 이 도망쳤다")
    }
}