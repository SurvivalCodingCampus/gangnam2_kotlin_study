package com.luca.kotlinstudy._12_debugging_lambda

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class ChartRoot(
    val collectionChartDataList: List<ChartCollection>
)

@Serializable
data class ChartCollection(
    val collectionName: String,
    val collectionSalePrice: List<ChartSalePrice>? = emptyList()
)

@Serializable
data class ChartSalePrice(
    val price: Double,
    val cvtDatetime: String
)

// 역직렬화
fun loadChartData(jsonFile: File): ChartRoot {
    require(jsonFile.exists()) {
        "JSON 파일을 찾을 수 없습니다: ${jsonFile.absolutePath}"
    }
    val jsonText = jsonFile.readText()
    val result = Json.decodeFromString<ChartRoot>(jsonText)
    return result
}

fun main() {
    val file = File("src/main/kotlin/com/luca/kotlinstudy/_12_debugging_lamda/chart_data.json")

    val result = loadChartData(file)

    println("총 데이터 개수: ${result.collectionChartDataList.size}")
    println("첫 번째 컬렉션 이름: ${result.collectionChartDataList.first().collectionName}")
}
