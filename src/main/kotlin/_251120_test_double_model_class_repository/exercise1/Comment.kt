package _251120_test_double_model_class_repository.exercise1

import kotlinx.serialization.Serializable

@Serializable
data class Comment(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)