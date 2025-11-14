package com.survivalcoding.kotlinstudy.`12_debugging_lamda`

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class CollectionChartDataList(
    val collectionChartDataList: List<CollectionChartData>
)

@Serializable
data class CollectionChartData(
    val collectionName: String,
    val collectionSalePrice: List<CollectionSalePrice>? = null
)

@Serializable
data class CollectionSalePrice(
    val price: Double,
    val cvtDatetime: String
)

// 역직렬화
fun deserialize(source: File): CollectionChartDataList {
    val jsonText = source.readText()
    return Json.decodeFromString(jsonText)

}

fun main() {
    val file = File("src/main/kotlin/com/survivalcoding/kotlinstudy/12_debugging_lamda/chart_data.json")

    val data = deserialize(file)

    println(data)
}