package com.survivalcoding.kotlinstudy.`02_instance_class`

fun main() {
    val slime = Slime("A", 10)
}

data class Slime(
    var name: String,
    val hp: Int = 10
) {
    val level = 10

    override fun toString(): String {
        return "Slime(name='$name', level=$level)"
    }
}