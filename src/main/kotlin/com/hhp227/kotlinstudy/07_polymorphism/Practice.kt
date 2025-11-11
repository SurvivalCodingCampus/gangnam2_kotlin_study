package com.hhp227.kotlinstudy.`07_polymorphism`

/*
연습문제1
빈칸에 들어갈 적절한 클래스명을 정하시오
    (1)                             (2)
    val item: Item = Sword()        val a: ____ = ____();
    _____ 인스턴스                    _____ 인스턴스

    _____ 를 생성했지만                Slime 을 생성했지만
    컴파일러에게는 _____ 로 보임         컴파일러에게는 _____ 로 보임

(1) Item
(2) Monster = Slime()

Sword 인스턴스를 생성했지만 컴파일러에게는 Item으로 보임
Slime 인스턴스를 생성했지만 컴파일러에게는 Monster로 보임

연습문제2
이런 클래스가 선언되어 있다.
다음 물음에 답하시오

val obj: X = A() 로 A인스턴스를 생성한 후, 변수 obj에서 호출할 수 있는 메소드를 a(), b(), c() 중에 골라보시오

a() 만 호출 가능

val y1: Y = A()
val y2: Y = B() 로 A와 B의 인스턴스를 생성한 후
y1.a()
y2.a() 를 실행했을 때에 화면에 표시되는 내용을 말하시오.

Aa
Ba



연습문제3
문제 2 에서 이용한 A클래스나 B클래스의 인스턴스를 각각 1개씩 생성하여, List 에 차례로 담는다.
그 후에 List 의 요소를 차례대로 꺼내 각각의 인스턴스의 b() 메소드를 호출 하여야 한다. 이상을 전제로 다음 물음에 답하시오.
List 변수의 타입으로 무엇을 사용하여야 하는가

List<Y>

위에서 설명하고 있는 프로그램을 작성하시오

fun main() {
    val list: List<Y> = listOf(A(), B())

    for (item in list) {
        item.b()
    }
}

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

interface X {
    fun a()
}

abstract class Y : X {
    abstract fun b()
}