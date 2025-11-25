package com.hhp227.kotlinstudy.`15_http`

import io.ktor.http.Headers

data class Response<T>(val statusCode: Int, val headers: Headers, val data: T)