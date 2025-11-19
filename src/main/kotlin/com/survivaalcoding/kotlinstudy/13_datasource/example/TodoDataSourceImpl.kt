package com.survivaalcoding.kotlinstudy.`13_datasource`.example

class TodoDataSourceImpl : TodoDataSource {
    override suspend fun getTodo(): List<Todo> {
        val path = "src/main/kotlin/com/survivaalcoding/kotlinstudy/13_datasource/example/todos.json"

        return SerializationUtils.deserialization(
            FileUtils.getFileText(path)
        )
    }
}