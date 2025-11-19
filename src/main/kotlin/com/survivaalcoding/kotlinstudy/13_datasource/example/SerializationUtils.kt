package com.survivaalcoding.kotlinstudy.`13_datasource`.example

import kotlinx.serialization.json.Json

abstract class SerializationUtils {
    companion object {
        inline fun <reified T> deserialization(value: String): T {
            return Json.decodeFromString(value)
        }
    }
}