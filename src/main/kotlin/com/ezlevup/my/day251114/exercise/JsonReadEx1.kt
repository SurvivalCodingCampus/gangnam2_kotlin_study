package com.ezlevup.my.day251114.exercise

import kotlinx.serialization.MissingFieldException
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class RootData(
    var collectionChartDataList: List<CollectionChartDataList>
)

@Serializable
data class CollectionChartDataList(
    var collectionName: String,
    var collectionSalePrice: List<CollectionSalePrice>
)

@Serializable
data class CollectionSalePrice(
    var price: Double,
    var cvtDatetime: String,
)

object ChartDataLoader {
    private var chartData: RootData? = null

    private fun jsonLoad(fileName: String): String {
        return File(fileName).readText()
    }

    fun chartDataLoad(fileName: String): RootData? {
        if (chartData != null) return chartData

        val json = jsonLoad(fileName)
        try {
            chartData = Json.decodeFromString<RootData>(json)
        } catch (e: MissingFieldException) {
            println(e.message)
            throw IllegalArgumentException("필수 필드 누락 오류: ${e.message}")
        } catch (e: Exception) {
            println(e.stackTraceToString())
            throw IllegalArgumentException("알수 없는 오류: ${e.message}")
        }

        return chartData
    }
}


fun main() {
    val fileName: String = "chart_data.json"
    val json = File(fileName).readText()
    // println(json)

    val chartData = ChartDataLoader.chartDataLoad(fileName)
    println(chartData)
    println(chartData?.collectionChartDataList!!.count())

}
