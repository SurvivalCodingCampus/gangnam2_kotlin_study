package _251114_debugging_lambda_expression.debugging

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File
import java.io.FileNotFoundException

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
    val file: String? = try {
        File("chart_data.txt").readText()
    } catch (e: FileNotFoundException) {
        null
    }
    if (file != null) {
        val collectionChartDataList: CollectionChartDataList = Json.decodeFromString(file)
        println(collectionChartDataList)
    } else {
        println("파일을 찾지 못했습니다.")
    }

}