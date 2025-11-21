package _251120_test_double_model_class_repository.exercise4


import kotlinx.serialization.Serializable

@Serializable
data class User(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)