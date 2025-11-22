package com.ezlevup.my.day251121

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean,
) {
    companion object {
        fun fromJson(jsonString: String): Todo {
            return Json.decodeFromString<Todo>(jsonString)
        }
    }
}
