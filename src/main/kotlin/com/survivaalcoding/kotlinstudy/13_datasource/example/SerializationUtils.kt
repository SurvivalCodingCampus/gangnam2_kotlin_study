package com.survivaalcoding.kotlinstudy.`13_datasource`.example

import kotlinx.serialization.json.Json

abstract class SerializationUtils {
    companion object {
        inline fun <reified T> deserialization(value: String): T {
            return Json.decodeFromString(value)
        }

        fun csvToJson(value: String): String {
            val lines = value.trim().lines()
            if (lines.isEmpty()) {
                return "[]"
            }

            val headers = lines.first().split(",")

            val jsonObject = lines.drop(1)
                .map { line ->
                    val data = line.split(",")

                    headers.indices.joinToString(prefix = "{", postfix = "}", separator = ",") { i ->
                        val value = data.getOrNull(i) ?: ""
                        val jsonValue = if (value == "null") "null" else "\"$value\""
                        "\"${headers[i]}\": $jsonValue"
                    }
                }

            return jsonObject.joinToString(prefix = "[", postfix = "]", separator = ",")
        }
    }
}