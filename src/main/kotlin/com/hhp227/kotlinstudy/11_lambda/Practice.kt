package com.hhp227.kotlinstudy.`11_lambda`

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.jvm.java

/*
파일에서 json 데이터를 읽어서 처리해야 한다. 이 데이터를 담을 수 있는 클래스를 작성하시오.


파일은 아래 링크에서 내려받아 파일 조작을 통해 읽어와서 활용할 것
https://gist.github.com/junsuk5/71eb1eadc17978492a83e8593fe5c9f0
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