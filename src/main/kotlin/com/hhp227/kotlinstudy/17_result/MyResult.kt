package com.hhp227.kotlinstudy.`17_result`

data class MyResult<T, E>(
    val data: T? = null,
    val error: E? = null,
    val status: Status
) {
    fun success(data: T): MyResult<T, Nothing> {
        return MyResult(data = data, status = Status.Success)
    }

    fun error(error: E): MyResult<Nothing, E> {
        return MyResult(error = error, status = Status.Error)
    }

    enum class Status {
        Success, Error
    }
}