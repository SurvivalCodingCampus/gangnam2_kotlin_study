package com.survivaalcoding.kotlinstudy.`13_datasource`.example

interface TodoDataSource {
    suspend fun getTodo(): Todo
}