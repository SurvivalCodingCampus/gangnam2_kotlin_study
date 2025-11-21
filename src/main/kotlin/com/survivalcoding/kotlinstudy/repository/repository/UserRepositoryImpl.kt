package com.survivalcoding.kotlinstudy.repository.repository

import com.survivalcoding.kotlinstudy.User
import com.survivalcoding.kotlinstudy.repository.data_source.JsonPlaceHolderApi
import com.survivalcoding.kotlinstudy.repository.data_source.UserDataSource
import java.net.http.HttpResponse

class UserRepositoryImpl(
    private val userDataSource: UserDataSource,
    private val postDataSource: JsonPlaceHolderApi,
) : UserRepository {

    override suspend fun getUsers(): List<User> {
        val response: HttpResponse = postDataSource.getData()
        response.headers

        return userDataSource.getUsers()
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        return getUsers().sortedBy { it.name }
            .take(10)
    }
}