package _251120_test_double_model_class_repository.exercise4


import kotlinx.serialization.Serializable

@Serializable
data class Geo(
    val lat: String,
    val lng: String
)