package com.hhp227.kotlinstudy.`17_result`.repository

import com.hhp227.kotlinstudy.`17_result`.NetworkError
import com.hhp227.kotlinstudy.`17_result`.User
import com.hhp227.kotlinstudy.`17_result`.Result

interface UserRepository {
    suspend fun getUserById(id: Int): Result<User, NetworkError>
    suspend fun getAllUsers(): Result<List<User>, NetworkError>
    suspend fun addUser(user: User): Result<Boolean, NetworkError>
}