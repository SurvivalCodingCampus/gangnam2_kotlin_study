package _251103_kotlin_oop.inheritance

const val SLIMEBASICATTCK = 10
const val SLIMEBASICHP = 50

open class Slime(
    val suffix: String
) {
    var hp = SLIMEBASICHP
    open fun attack(hero: Hero) {
        println("슬라임 $suffix 가 공격했다")
        println("${SLIMEBASICATTCK}의 데미지")
        hero.hp -= SLIMEBASICATTCK
    }
}