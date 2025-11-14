package _251114_debugging_lambda_expression.debugging

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
    val collectionSalePrice: List<CollectionSale>,
)

@Serializable
data class CollectionSale(
    val price: Double,
    val cvtDatetime: String
)

fun main() {
    val file = File("chart_data.txt").readText()
    val collectionChartDataList: CollectionChartDataList = Json.decodeFromString(file)
    println(collectionChartDataList)

}