package com.survivaalcoding.kotlinstudy.`02_instance_class`

class Slime(var hp: Int, val suffix: String) {
    val level = 10

    fun run() = println("슬라임 ${suffix}가 도망갔다")
}
