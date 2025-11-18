package com.ezlevup.my.day251114.exercise

import kotlin.math.max
import kotlin.math.min

data class Trader(val name: String, val city: String)

data class Transaction(val trader: Trader, val year: Int, val value: Int)

fun main() {
    val transactions = listOf(
        Transaction(Trader("Brian", "Cambridge"), 2011, 300),
        Transaction(Trader("Raoul", "Cambridge"), 2012, 1000),
        Transaction(Trader("Raoul", "Cambridge"), 2011, 400),
        Transaction(Trader("Mario", "Milan"), 2012, 710),
        Transaction(Trader("Mario", "Milan"), 2012, 700),
        Transaction(Trader("Alan", "Cambridge"), 2012, 950)
    )

    println("1 ===========================================================")
    // 1. 2011년에 일어난 모든 트랜잭션을 찾아 가격 기준 오름차순으로 정리하여 이름을 나열하시오
    transactions.filter { it.year == 2011 }
        .sortedBy { it.value }
        .forEach { println(it.trader.name) }
    // Brian Raoul

    println("2 ===========================================================")
    // 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오
    transactions.map { it.trader.city }.toSet().forEach(::println)
    // Cambridge Milan

    println("3 ===========================================================")
    // 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하여 나열하시오
    transactions.filter { it.trader.city == "Cambridge" }
        .sortedBy { it.trader.name }
        .map { it.trader.name }
        .toSet()
        .forEach(::println)
    // Alan
    // Brian
    // Raoul

    println("4 ===========================================================")
    // 4. 모든 거래자의 이름을 알파벳순으로 정렬하여 나열하시오
    transactions.map { it.trader.name }
        .sortedBy { it }
        .toSet()
        .forEach(::println)
    // Alan
    // Brian
    // Mario
    // Raoul

    println("5 ===========================================================")
    // 5. 밀라노에 거래자가 있는가?
    println(transactions.any { it.trader.city == "Milan" })
    // true

    println("6 ===========================================================")
    // 6. 케임브리지에 거주하는 거래자의 모든 트랙잭션값을 출력하시오
    transactions.filter { it.trader.city == "Cambridge" }
        .map { it.value }
        .forEach { it -> println(it) }
    // 300
    // 1000
    // 400
    // 950

    println("7 ===========================================================")
    // 7. 전체 트랜잭션 중 최대값은 얼마인가?
    println(transactions.map { it.value }.reduce(::max))
    // 1000

    println("8 ===========================================================")
    // 8. 전체 트랜잭션 중 최소값은 얼마인가?
    println(transactions.map { it.value }
        .reduce { acc, i -> min(acc, i) })
    // 300

}
