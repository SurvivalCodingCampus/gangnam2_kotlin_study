package _251113_exception_file_variety_data_format.variety_data_format

import kotlinx.serialization.Serializable

@Serializable
data class Employee(
    var name: String,
    var age: Int
)