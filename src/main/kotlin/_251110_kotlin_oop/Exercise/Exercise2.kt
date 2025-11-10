package _251110_kotlin_oop.Exercise.Exercise2

/*
문제 2 에서 이용한 A클래스나 B클래스의 인스턴스를 각각 1개씩 생성하여, List 에 차례로 담는다.
그 후에 List 의 요소를 차례대로 꺼내 각각의 인스턴스의 b() 메소드를 호출 하여야 한다. 이상을 전제로 다음 물음에 답하시오.

연습문제 3-1.
List 변수의 타입으로 무엇을 사용하여야 하는가
==> 둘의 공통인 Y로 해야한다.

연습문제 3-2.
위에서 설명하고 있는 프로그램을 작성하시오
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

