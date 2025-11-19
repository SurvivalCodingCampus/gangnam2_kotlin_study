package com.survivaalcoding.kotlinstudy.`13_datasource`.example

class UserDataSourceImpl : UserDataSource {
    override suspend fun getUsers(): List<User> {
        val path = "src/main/kotlin/com/survivaalcoding/kotlinstudy/13_datasource/example/users.json"

        return SerializationUtils.deserialization(
            FileUtils.getFileText(path)
        )
    }
}