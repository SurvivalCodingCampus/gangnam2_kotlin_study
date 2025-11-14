package _251114_debugging_lambda_expression.lambda_expression


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

    //1.
    println("1번문제")
    transactions.filter { it.year == 2011 }.sortedBy { it.trader.name }.forEach { println(it.trader.name) }
    //2.
    println("2번문제")
    transactions.distinctBy { it.trader.city }.forEach { println(it.trader.city) }
    //3.
    println("3번문제")
    transactions.filter { it.trader.city == "Cambridge" }.sortedBy { it.trader.name }.distinctBy { it.trader.name }
        .forEach { println(it.trader.name) }
    //4.
    println("4번문제")
    transactions.sortedBy { it.trader.name }.forEach { println(it.trader.name) }
    //5.
    println("5번문제")
    println(transactions.any { it.trader.city == "Milan" })
    //6.
    println("6번문제")
    transactions.filter { it.trader.city == "Cambridge" }.forEach { println(it.value) }
    //7.
    println("7번문제")
    println(transactions.maxOf { it.value })
    //8.
    println("8번문제")
    println(transactions.minOf { it.value })
}
