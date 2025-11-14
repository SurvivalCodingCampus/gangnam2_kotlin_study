package com.neouul.sesac.`10-debugging`

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

fun main() {
    val file = File("docs/file/chart_data.json")
    val json = file.readText()
//    println(json.substring(50))

    val obj = Json.decodeFromString<CollectionChartDataList>(json)
    println(obj)
}