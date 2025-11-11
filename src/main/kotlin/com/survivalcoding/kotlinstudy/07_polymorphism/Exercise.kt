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
 * 연습문제 2. 정답 고르기
 * 1. a()
 * 2. Aa, Ba
 */

/**
 * 연습문제 3.
 * 1. Y를 사용해야 한다.
 *
 * A와 B 클래스 모두 Y 클래스를 상속
 * X는 인터페이스로서 a()만 정의하고 있는데 호출하고 싶은 메서드는 b()
 * b()는 X에는 없음
 * b()는 Y에 추상 메소드로 정의되어 있고 A, B는 이 b()를 각각 오버라이드하고 있음
 * 따라서 b()를 호출하려면 Y 타입
 *
 * 2. 코드
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

    // 연습문제 3. 코드 작성
    // A, B 인스턴스 각각 생성
    val a = A()
    val b = B()

    // List<Y> 타입으로 담기
    val list: List<Y> = listOf(a, b)

    // 리스트를 순회하면서 b() 호출
    for (element in list) {
        element.b()
    }
}