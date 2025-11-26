package com.sesac.kotlinstudy.day17.result

sealed class Result<out T, out E> {
    data class Success<out T>(val data: T) : Result<T, Nothing>()
    data class Error<out E>(val error: E) : Result<Nothing, E>()
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

            return Result.Success(emptyList())
        } catch (e: Exception) {
            return Result.Error(e.message!!)
        }
    }
}
