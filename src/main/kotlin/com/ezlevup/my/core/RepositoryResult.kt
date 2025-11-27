package com.ezlevup.my.core

sealed class RepositoryResult<out T, out E> {
    data class Success<out T>(val data: T) : RepositoryResult<T, Nothing>()
    data class Error<out E>(val error: E) : RepositoryResult<Nothing, E>()
}
