package com.survival.kotlinstudy.datasource

interface TodoDataSource {
    suspend fun getTodo(): Todo
}