package com.survivalcoding.kotlinstudy.`16_result`

fun main() {

}

sealed class Result<out T, out E> {
    data class Success<out T>(
        val data: T
    ) : Result<T, Nothing>()

    data class Error<out E>(
        val error: E
    ) : Result<Nothing, E>()
}

data class Item(val name: String)

class DataSource {
    fun findAll(): List<Item> = emptyList()
}

class Repository(
    private val dataSource: DataSource,
) {

    fun getItems(): Result<List<Item>, String> {
        try {
            dataSource.findAll()

            return Result.Success(data = emptyList())

        } catch (e: Exception) {
            return Result.Error(e.message!!)
        }
    }
}

class Repository2(
    private val dataSource: DataSource,
) {
    fun getItems(): Result<List<Item>, String> {

        // 1. runCatching 블록: 내부의 코드(findAll()) 실행 중 발생한 예외를 잡아줍니다.
        return kotlin.runCatching {
            dataSource.findAll()
        }.fold(
            onSuccess = { items -> Result.Success(data = items) },
            onFailure = { throwable ->
                val errorMessage = throwable.message ?: "알 수 없는 데이터 소스 오류 발생"
                Result.Error(error = errorMessage)
            }
        )
    }
}