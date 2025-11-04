package com.ezlevup.my.exercise

open class Slime(
    val suffix: String, // 구분자
) {
    companion object {
        const val MAX_HP: Int = 50
        const val BASE_DAMAGE: Int = 10
    }

    var hp = Slime.MAX_HP

    open fun attack(hero: Hero) {
        val damage = slimeDamage(hero)
        println("슬라임 $suffix 가 공격했다.")
        println("$damage 의 데미지")
        hero.takeDamage(damage)
    }

    fun slimeDamage(hero: Hero): Int {
        println("Slime calculateDamage")
        return Slime.BASE_DAMAGE
    }
}
