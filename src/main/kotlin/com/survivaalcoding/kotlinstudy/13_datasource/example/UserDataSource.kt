package com.survivaalcoding.kotlinstudy.`13_datasource`.example

interface UserDataSource {
    suspend fun getUsers(): List<User>
}