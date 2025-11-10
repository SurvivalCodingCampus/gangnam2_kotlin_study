package com.luca.kotlinstudy._07_polymorphism

class Practice2 {
}

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
//  문제 1
    val obj: X = A()
//  정답은 ? a() 타입은 결국 X이기 때문에 a
//// A를 생성했지만 컴파일러상 obj는 X 타입으로 취급

//  문제 2
    val y1: Y = A()
    val y2: Y = B()
    y1.a()
    y2.a()
//  정답은 ? y1의 A()가 실제 인스턴스 Aa
//          y2의 B()가 실제 인스턴스 Ba

// 문제 3
    // A, B 인스턴스를 각각 하나씩 생성
    val a = A()
    val b = B()
//  정답은 ? A와 B는 전부 Y클래스를 상속 그래서 공통타입은 Y
    // List의 타입은 Y
    val list: List<Y> = listOf(a, b)
    // 각 요소를 꺼내어 각 인스턴스의 b를 호출
    for (item in list) {
        item.b()
    }
}
