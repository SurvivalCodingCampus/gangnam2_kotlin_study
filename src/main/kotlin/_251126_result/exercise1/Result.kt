package _251126_result.exercise1

sealed class Result<T, E> {
    data class Success<T>(
        val data: T
    ) : Result<T, Nothing>()

    data class Error<E>(
        val error: E
    ) : Result<Nothing, E>()
}