package com.hhp227.kotlinstudy.`08_instance_basic`

import com.hhp227.kotlinstudy.`02_instance_class`.Hero

fun main() {
    val a = 10
    val b = a

    println(a === b)

    val c = "홍길동"
    val d = c

    println(c === d)

    val h1 = Hero("홍")
    val h2 = Hero(h1.name)
    val h3 = h1.copy()
    val h4 = h1.copy("김")

    println(h1 === h2)
    println(h1 == h2)
}