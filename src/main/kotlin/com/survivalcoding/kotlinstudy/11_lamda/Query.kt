package com.survivalcoding.kotlinstudy.`11_lamda`

import kotlin.collections.filter

data class Trader(val name: String, val city: String)

data class Transaction(val trader: Trader, val year: Int, val value: Int)

fun main() {
    val transactions: Iterable<Transaction> = listOf(
        Transaction(Trader("Brian", "Cambridge"), 2011, 300),
        Transaction(Trader("Raoul", "Cambridge"), 2012, 1000),
        Transaction(Trader("Raoul", "Cambridge"), 2011, 400),
        Transaction(Trader("Mario", "Milan"), 2012, 710),
        Transaction(Trader("Mario", "Milan"), 2012, 700),
        Transaction(Trader("Alan", "Cambridge"), 2012, 950)
    )


    // 1. 2011년에 일어난 모든 트랜잭션을 찾아 가격 기준 오름차순으로 정리하여 이름을 나열하시오
    println(transactions.filter { it.year == 2011 }
        .sortedBy { it.value }
        .map { it.trader.name }
        .distinct() // set -> list
    )

    someFunction {
        println("Hello World")
    }

    transactions.maxOf { transaction: Transaction -> transaction.value }

//    transactions.filter { it.year == 2011 }
//        .sortedBy { it.value }
//        .map { it.trader.name }
//        .toSet()
//        .forEach { println(it) }
}

inline fun someFunction(lambda: () -> Unit) {
    println("someFunction!!!!")
    lambda()
    println("someFunction????")
}