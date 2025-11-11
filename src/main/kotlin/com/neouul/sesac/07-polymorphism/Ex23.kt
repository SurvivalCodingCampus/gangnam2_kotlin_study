package com.neouul.sesac.`07-polymorphism`

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

fun main(){
    // 연습문제 2
    println("=== 연습문제 2 ===")
    val obj: X = A()
    obj.a()

    val y1: Y = A()
    val y2: Y = B()
    y1.a()
    y2.a()


    // 연습문제 3
    println("=== 연습문제 3 ===")
    val a = A()
    val b = B()
    val list: List<Y> = listOf(a, b)
    list.forEach { it.b() }
}