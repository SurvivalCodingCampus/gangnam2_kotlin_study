package com.hhp227.kotlinstudy.`02_instance_class`

const val SLIME_LEVEL = 10

class Slime(hp: Int, val suffix: String) {
    val level = SLIME_LEVEL

    fun run() {
        println("슬라임 ${suffix}가 도망갔다.")
    }
}