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

/*
3번.

문제 2 에서 이용한 A클래스나 B클래스의 인스턴스를 각각 1개씩 생성하여, List 에 차례로 담는다.
그 후에 List 의 요소를 차례대로 꺼내 각각의 인스턴스의 b() 메소드를 호출 하여야 한다. 이상을 전제로 다음 물음에 답하시오.

1) List 변수의 타입으로 무엇을 사용하여야 하는가
2) 위에서 설명하고 있는 프로그램을 작성하시오
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

