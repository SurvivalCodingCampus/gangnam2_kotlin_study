package com.sesac.practice.day04

class QuizPerson(val name: String)

fun main() {
    /**
     * 연습문제 1-1
     * 중복되는 도시 이름이 없으므로 `Set`
     * 대한민국에 있는 도시인지 검색할 때 효율적이기 때문
     */
    val cities = setOf("서울", "제주")

    /**
     * 연습문제 1-2
     * 누가 몇점을 받았는지 필요하다면 `Map`
     * Key: 누가, Value: 점수를 담아야하기 때문
     */
    val scores = mapOf(
        "철수" to 10,
        "영희" to 20,
    )

    /**
     * 연습문제 1-2
     * 시험 점수만 필요하다면 `List`
     * 중복되는 점수가 있을수도 있기 때문
     */
    val scores2 = listOf(10, 20)

    /**
     * 연습문제 1-3
     * 도시별로 어떤 도시에 몇명이 사는지 저장하기 위해 `Map
     * Key: 도시명, Value: 인구수를 담아야하기 때문
     */
    val population = mapOf(
        "서울" to 100,
        "제주" to 30,
    )

    // 연습문제 2
    val hong = QuizPerson("홍길동")
    val han = QuizPerson("한석봉")

    val list = listOf(hong, han)

    list.forEach {
        println(it.name)
    }

    // 연습문제 3
    val map = mapOf(
        hong to 20,
        han to 25,
    )

    map.entries.forEach {
        println("${it.key.name}의 나이는 ${it.value}살")
    }
}
