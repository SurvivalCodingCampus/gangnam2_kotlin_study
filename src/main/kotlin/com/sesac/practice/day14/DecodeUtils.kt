package com.sesac.practice.day14

import kotlinx.serialization.json.Json
import java.io.File

inline fun <reified T> File.decodeFromFile(): T {
    val json = this.readText()

    return Json.decodeFromString(json)
}
