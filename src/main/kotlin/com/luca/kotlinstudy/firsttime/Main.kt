package com.luca.kotlinstudy.firsttime

//val PI = 3.14
//var x = 0
fun main() {
    println("Hello World")

    readln()

    // 상수
    val x = 5 // 타입추론
    val s = "핼로"

    // 변수
    var y = 5

    // 다형성
    //val z: Long = x 안들어 가진다. 왜? 자바와 달리 기본타입이 없는 완벽한 객체지향이기 때문
    val z: Long = x.toLong()
    y = 10L.toInt()

    // if expression 식
    val a = 1
    val b = 2

    val result = (if (a > b) a else b) // Returns a value: 2
    println(result)
    // when식
    val add = when(a) {
        1-> 10
        2 -> 20
        else -> 30
    }

    //val list: List<Int> = 1..4.toList()

    // for 문
    for (number in 1..5) {
        // number is the iterator and 1..5 is the range
        print(number)
    }
// 12345
    repeat(10) {
        println()
    }
    // list
    // named arguments
    sum (10, 20)
    sum (a = 10, b =20)
    sum (b = 20, a =10)

    // defalut paramiter value 원래는 메서드 오버로딩을 해줘야 한다.
    sum (10)
    sum (a = 10)

    /*
    Null safety

    ? 가 있으면 Null 허용
    ? 가 없으면 Null 불허용
    Null은 최대한 배제하자.
     */
    var name: String = "홍길동"
   // name = null

    var name2: String? = "홍길동"
    name2 = null

   // println(name2.toInt())

}

fun sum(a : Int, b: Int= 10): Int { // a를 받을 건데 Int 로 받겠다.  괄호 뒤는 반환 타입
    return  a + b
}