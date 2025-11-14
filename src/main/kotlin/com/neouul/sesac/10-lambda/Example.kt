package com.neouul.sesac.`10-lambda`

fun main() {

    // 람다식 lambda expression
    val sumLambda: (Int, Int) -> Int = { a, b -> a + b }
    // 단일 매개변수 람다 (람다의 매개변수가 하나인 경우 매개변수를 생략하고 it을 사용할 수 있다)
    val square: (Int) -> Int = { it * it }

    // 후행 람다 (함수의 마지막 인자가 람다일 경우, 람다를 소괄호 밖으로 뺄 수 있다)
    repeat(3, { println(it) })
    repeat(5, { println(square(it)) })

    val list = listOf(1, 2, 3)
    list.forEach(::myFunction)
}

fun myFunction(i: Int) {
    println(i)
}