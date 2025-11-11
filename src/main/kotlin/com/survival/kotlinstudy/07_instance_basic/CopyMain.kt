package com.survival.kotlinstudy.`07_instance_basic`

import com.survival.kotlinstudy.`05_inheritance`.Slime

fun main() {
    val a = 10
    val b = a

    println(a === b)

    val c = "홍길동"
    val d = c
    println(c === c)


}