package _251120_test_double_model_class_repository.exercise5


import kotlinx.serialization.Serializable

@Serializable
data class Album(
    val id: Int,
    val title: String,
    val userId: Int
)