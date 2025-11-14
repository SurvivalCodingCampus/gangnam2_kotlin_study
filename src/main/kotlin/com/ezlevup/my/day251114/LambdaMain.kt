package com.ezlevup.my.day251114

import kotlin.math.max

class LambdaMain {
}

fun printElement(element: Int) {
    println(element)
}

fun main() {
    val list = listOf<Int>(1, 2, 3)
    list.forEach(::printElement)
    list.forEach { e -> printElement(e) }

    val listStr = listOf<String>("1", "2", "3")
    // listStr.forEach(::printElement) // 타입이 틀리다.

    // 함수를 값에 저장
    val loudify = { msg: String -> "!!! ${msg.uppercase()} !!!" }
    println(loudify("hello"))

    list.sortedWith(object : Comparator<Int> {
        override fun compare(o1: Int, o2: Int): Int {
            return o1 - o2
        }
    })

    list.sortedWith { o1, o2 -> o1 - o2 }


    // 무명클래스 → 람다식 → 후행 람다 → 각종 생략


    // filter 함수
    val items = listOf<Int>(1, 2, 3, 4, 5)

    items.filter { it % 2 == 0 }.forEach(::println) // 2, 4

    // map 함수
    items.filter { it % 2 == 0 }
        .map { "숫자 $it" }
        .forEach { i -> println(i) }

    // toSet()
    val result1 = items.filter { it % 2 == 0 }.toSet().toList()
    val result2 = items.filter { it % 2 == 0 }.distinct()
    println(result1)

    // any // 특정 조건을 충족하는 요소가 있는지를 검사할 때 사용합니다.
    println(items.any { it % 2 == 0 }) // true

    // reduce
    // 반복 요소를 줄여가면서 결과를 만들 때 사용하는 함수입니다.
    println(items.reduce { acc, i -> max(acc, i) })
    println(items.reduce(::max)) // 5

    // 안티패턴
    // forEach 에서 중단 시도
    // 전통적인 for 문 사용


}
