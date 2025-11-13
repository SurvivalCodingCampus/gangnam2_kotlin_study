package _251113_exception_file_variety_data_format.exception

fun main() {
    val numString = "10.5"
    val num = try {
        numString.toInt()
    } catch (e: Exception) {
        0
    }
    println(num)

}