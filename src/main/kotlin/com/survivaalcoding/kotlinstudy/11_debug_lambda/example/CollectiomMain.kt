package com.survivaalcoding.kotlinstudy.`11_debug_lambda`.example

import kotlinx.serialization.json.Json
import java.io.File

fun main() {
    val file = File("chart_data.json")
    val jsonChartData = file.readText()

    val collectionChartDatas = Json.decodeFromString<CollectionChartData>(jsonChartData)
    for (list in collectionChartDatas.collectionChartDataList) {
        println(list)
    }
}