package com.neouul.sesac.`05-inheritance`

open class Hero(
    var name: String,
    var hp: Int,
) {
    open fun attack(slime: Slime) {
        println("$name 이 $slime 을 공격했다")
        println("슬라임의 반격을 받았다")
        hp -= 10
    }

    open fun run() {
        println("$name 이 도망쳤다")
    }
}