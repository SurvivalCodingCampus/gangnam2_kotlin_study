package com.survivalcoding.kotlinstudy.common

import kotlinx.serialization.json.Json
import java.io.File

// 일반 제네릭은 타입을 컴파일 타임에 지워버려서 reified T 로 유지
inline fun <reified T> readJsonFile(path: String): T {
    val json = File(path).readText()
    return Json.decodeFromString(json)
}