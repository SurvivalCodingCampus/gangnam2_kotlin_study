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
    var collectionSalePrice: List<CollectionSalePrice>? = null
)

@Serializable
data class CollectionSalePrice(
    var price: Double,
    var cvtDatetime: String,
)


fun main() {
    val fileName: String = "chart_data.json"
    val json = File(fileName).readText()
    // println(json)

    try {
        val rootData = Json.decodeFromString<RootData>(json)
        println(rootData.collectionChartDataList.count())
    } catch (e: MissingFieldException) {
        println(e.message)
    } catch (e: Exception) {
        e.stackTraceToString()
    }

}
