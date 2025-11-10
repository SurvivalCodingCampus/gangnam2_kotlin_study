package com.survivalcoding.kotlinstudy.`07_polymorphism`.practice

/*
2번.

이런 클래스가 선언되어 있다. 다음 물음에 답하시오

1)  val obj: X = A() 로 A인스턴스를 생성한 후, 변수 obj에서 호출할 수 있는 메소드를 a(), b(), c() 중에 골라보시오
답:
a()

2)  val y1: Y = A()
    val y2: Y = B() 로 A와 B의 인스턴스를 생성한 후
    y1.a()
    y2.a() 를 실행했을 때에 화면에 표시되는 내용을 말하시오.
답:
Aa
Ba

*/

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