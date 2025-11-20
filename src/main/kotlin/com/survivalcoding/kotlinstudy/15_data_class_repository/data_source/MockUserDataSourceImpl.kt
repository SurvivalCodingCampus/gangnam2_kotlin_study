package com.survivalcoding.kotlinstudy.`15_data_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_data_class_repository`.model.User
import com.survivalcoding.kotlinstudy.common.readJsonFile

class MockUserDataSourceImpl : UserDataSource {
    override suspend fun getUsers(): List<User> {
        return readJsonFile("src/main/resources/15_model_class_repository/users.json")
    }
}