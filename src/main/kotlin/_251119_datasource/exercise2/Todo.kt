package _251119_datasource.exercise2

import kotlinx.serialization.Serializable

const val FILE_PATH =
    "src\\main\\kotlin\\_251119_datasource\\exercise2\\todos.json"

@Serializable
data class Todo(
    val userId: Int = -1,
    val id: Int = -1,
    val title: String = "",
    val completed: Boolean = false
)
