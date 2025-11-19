package com.sesac.practice.day13

interface TodoDataSource {
    suspend fun getTodo(): Todo
}
