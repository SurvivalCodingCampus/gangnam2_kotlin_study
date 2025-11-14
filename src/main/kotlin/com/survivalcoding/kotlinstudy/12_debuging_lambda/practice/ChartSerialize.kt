package com.survivalcoding.kotlinstudy.`12_debuging_lambda`.practice

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

/*
파일에서 json 데이터를 읽어서 처리해야 한다. 이 데이터를 담을 수 있는 클래스를 작성하시오
*/

@Serializable
data class SalePrice(
    val price: Double? = null,
    val cvtDatetime: LocalDateTime? = null
)

@Serializable
data class ChartData(
    val collectionName: String = "",
    val collectionSalePrice: List<SalePrice> = emptyList()
)

@Serializable
data class ChartDataList(
    val collectionChartDataList: List<ChartData> = emptyList()
)

@Serializable
abstract class ChartSerialize {
    companion object {
        fun obj(source: File): ChartDataList =
            Json.decodeFromString<ChartDataList>(source.readText())
    }
}

fun main() {
    val file = File("chart_data.json")
    val chart = ChartSerialize.obj(file)

    chart.collectionChartDataList.forEach { println(it) }
}
