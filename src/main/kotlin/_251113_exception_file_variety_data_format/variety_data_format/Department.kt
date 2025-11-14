package _251113_exception_file_variety_data_format.variety_data_format

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class Department(
    var name: String,
    var leader: Employee
)

fun saveToFile(department: Department) {
    val file = File("company.txt")
    val json = Json.encodeToString(department)
    file.writeText(json)
}
