package com.survivalcoding.kotlinstudy.`07_instance_basic`

import com.survivalcoding.kotlinstudy.`02_instance_class`.Hero
import com.survivalcoding.kotlinstudy.`02_instance_class`.Slime

fun main() {
    // 숫자(primitive), 문자열
    val a = 10
    val b = a

    println(a === b)

    val c = "홍길동"
    val d = c

    println(c === d)

    val h1 = Hero("홍")
    val h2 = Hero(h1.name, h1.hp)
    val h3 = h1.copy()
    val h4 = h1.copy(name = "김")
    val h5 = h1.copy(hp = 100)
    println(h1)

    println(h1 === h2)

    println(h1 == h2)

    val slime1 = Slime("A")
    val slime2 = slime1.copy()

    println(slime1 === slime2)
}