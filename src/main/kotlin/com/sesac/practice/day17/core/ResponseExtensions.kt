package com.sesac.practice.day17.core

fun <T> Response<T>.isSuccess(): Boolean = this.statusCode in (200 until 300)
fun <T> Response<T>.isClientError(): Boolean = this.statusCode in (400 until 500)
fun <T> Response<T>.isServerError(): Boolean = this.statusCode in (500 until 600)
fun <T> Response<T>.isFail(): Boolean = this.isClientError() || this.isServerError()
