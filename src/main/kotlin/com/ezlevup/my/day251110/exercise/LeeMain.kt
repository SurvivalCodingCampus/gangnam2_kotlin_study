package com.ezlevup.my.day251110.exercise

class LeeMain {
}

fun main() {
    val obj: X = A()
    // obj.a() // ok

    val y1: Y = A()
    val y2: Y = B()
    // y1.a()
    // y2.a()

    val list: List<Y> = listOf(y1, y2)

    for (i: Y in list) {
        i.a()
    }
}
