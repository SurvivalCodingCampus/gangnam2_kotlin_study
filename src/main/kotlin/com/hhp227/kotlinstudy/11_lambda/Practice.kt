package com.hhp227.kotlinstudy.`11_lambda`

import kotlinx.serialization.Serializable
import java.io.BufferedReader
import java.io.InputStreamReader

/*
파일에서 json 데이터를 읽어서 처리해야 한다. 이 데이터를 담을 수 있는 클래스를 작성하시오.


파일은 아래 링크에서 내려받아 파일 조작을 통해 읽어와서 활용할 것
https://gist.github.com/junsuk5/71eb1eadc17978492a83e8593fe5c9f0
 */

/*
class ChartDataLoader {

    fun loadJsonFile(): File {
        val inputStream = this::class.java.classLoader
            .getResourceAsStream("chart_data.json")
            ?: throw IllegalArgumentException("chart_data.json not found")

        // 임시 파일 생성
        val tempFile = File.createTempFile("chart_data", ".json")

        // InputStream → File 복사
        inputStream.use { input ->
            tempFile.outputStream().use { output ->
                input.copyTo(output)
            }
        }

        return tempFile
    }

    fun loadJson(): String {
        val file = loadJsonFile()
        return file.readText()
    }
}

 */

class ChartDataLoader {
    fun loadJson(): String {
        val inputStream = this::class.java.classLoader.getResourceAsStream("chart_data.json")
            ?: throw IllegalArgumentException("chart_data.json not found")
        return BufferedReader(InputStreamReader(inputStream)).use(BufferedReader::readText)
    }
}

@Serializable
data class ChartData(val collectionChartDataList: List<CollectionChartData>)

@Serializable
data class CollectionChartData(val collectionName: String, val collectionSalePrice: List<SalePrice> = emptyList())

@Serializable
data class SalePrice(val price: Double, val cvtDatetime: String)

/*
연습문제-쿼리(Query)
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
}

// 1. 2011년에 일어난 모든 트랜잭션을 찾아 가격 기준 오름차순으로 정리하여 이름을 나열하시오
// 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오
// 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하여 나열하시오
// 4. 모든 거래자의 이름을 알파벳순으로 정렬하여 나열하시오
// 5. 밀라노에 거래자가 있는가?
// 6. 케임브리지에 거주하는 거래자의 모든 트랙잭션값을 출력하시오
// 7. 전체 트랜잭션 중 최대값은 얼마인가?
// 8. 전체 트랜잭션 중 최소값은 얼마인가?
 */

data class Trader(val name: String, val city: String)

data class Transaction(val trader: Trader, val year: Int, val value: Int)

class LambdaPractice {
    val transactions = listOf(
        Transaction(Trader("Brian", "Cambridge"), 2011, 300),
        Transaction(Trader("Raoul", "Cambridge"), 2012, 1000),
        Transaction(Trader("Raoul", "Cambridge"), 2011, 400),
        Transaction(Trader("Mario", "Milan"), 2012, 710),
        Transaction(Trader("Mario", "Milan"), 2012, 700),
        Transaction(Trader("Alan", "Cambridge"), 2012, 950)
    )

    // 1. 2011년에 일어난 모든 트랜잭션을 찾아 가격 기준 오름차순으로 정리하여 이름을 나열하시오
    fun getSolution1() = transactions.filter { it.year == 2011 }.sortedBy { it.value }.map { it.trader.name }

    // 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오
    fun getSolution2() = transactions.map { it.trader.city }.toSet()

    // 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하여 나열하시오
    fun getSolution3() = transactions.filter { it.trader.city == "Cambridge" }.sortedBy { it.trader.name }

    // 4. 모든 거래자의 이름을 알파벳순으로 정렬하여 나열하시오
    fun getSolution4() = transactions.map { it.trader.name }.sorted()

    // 5. 밀라노에 거래자가 있는가?
    fun solution5() = transactions.any { it.trader.city == "Milan" }

    // 6. 케임브리지에 거주하는 거래자의 모든 트랙잭션값을 출력하시오
    fun solution6() = transactions.filter { it.trader.city == "Cambridge" }

    // 7. 전체 트랜잭션 중 최대값은 얼마인가?
    fun solution7() = transactions.maxOf { it.value }

    // 8. 전체 트랜잭션 중 최소값은 얼마인가?
    fun solution8() = transactions.minOf { it.value }
}