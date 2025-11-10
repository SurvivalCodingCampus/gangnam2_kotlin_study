package com.survivalcoding.kotlinstudy.`07_polymorphism`

/**
 * 연습문제 1. 적절한 클래스 명
 * (1)
 * Item
 * Item, Sword
 *
 * (2)
 * val a: Monster = Slime()
 * Monster
 * Slime
 */

/**
 * 연습문제 2.
 * 1. a()
 * 2. Aa, Ba
 */

interface X {
    fun a()
}

abstract class Y : X {
    abstract fun b()
}

class A : Y() {
    override fun b() {
        println("Ab")
    }

    override fun a() {
        println("Aa")
    }

    fun c() {
        println("Ac")
    }
}

class B : Y() {
    override fun b() {
        println("Bb")
    }

    override fun a() {
        println("Ba")
    }

    fun c() {
        println("Bc")
    }
}

fun main() {
    val obj: X = A()
    obj.a()

    val y1: Y = A()
    val y2: Y = B()

    y1.a()
    y2.a()
}