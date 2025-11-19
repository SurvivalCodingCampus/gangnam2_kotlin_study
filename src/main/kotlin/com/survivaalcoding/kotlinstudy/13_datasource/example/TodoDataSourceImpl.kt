package com.survivaalcoding.kotlinstudy.`13_datasource`.example

class TodoDataSourceImpl : TodoDataSource {
    override suspend fun getTodo(): Todo {
        val path = "src/main/kotlin/com/survivaalcoding/kotlinstudy/13_datasource/example/todo.json"

        return SerializationUtils.deserialization(
            FileUtils.getFileText(path)
        )
    }
}