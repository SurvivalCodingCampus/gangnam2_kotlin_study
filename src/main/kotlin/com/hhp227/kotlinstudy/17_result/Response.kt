package com.hhp227.kotlinstudy.`17_result`

import io.ktor.http.*

data class Response<T>(val statusCode: Int, val headers: Headers, val data: T)