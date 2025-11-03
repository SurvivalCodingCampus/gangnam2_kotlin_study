package com.sesac.practice.day05

open class Hero(
    val name: String,
    var hp: Int = MAX_HP,
) {
    companion object {
        const val MAX_HP = 50
    }
}
