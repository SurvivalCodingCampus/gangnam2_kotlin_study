package _251120_test_double_model_class_repository.exercise3


import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)