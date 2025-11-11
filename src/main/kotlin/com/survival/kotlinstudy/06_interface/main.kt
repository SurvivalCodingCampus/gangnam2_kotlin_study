package com.survival.kotlinstudy.`06_interface`

fun main() {
    val obj: X = A()
    obj.a()

    val y1 = A()
    val y2 = B()

    y1.a()
    y2.a()

    val list = mutableListOf<Y>()
    list.add(y1)
    list.add(y2)

    list.forEach {
        it.b()
    }

}