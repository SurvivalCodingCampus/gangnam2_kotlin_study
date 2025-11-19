package _251119_datasource.exercise1

import kotlinx.serialization.Serializable

const val FILE_PATH =
    "src\\main\\kotlin\\_251119_datasource\\exercise1\\todo.json"

@Serializable
data class Todo(
    val userId: Int = -1,
    val id: Int = -1,
    val title: String = "",
    val completed: Boolean = false
)
