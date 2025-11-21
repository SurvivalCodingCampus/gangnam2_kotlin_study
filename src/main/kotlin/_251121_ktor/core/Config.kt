package _251121_ktor.core

const val BASEURL = "https://jsonplaceholder.typicode.com/posts"

data class Response<T>(
    val body: T,
    val statusCode: Int,
    val header: String
)