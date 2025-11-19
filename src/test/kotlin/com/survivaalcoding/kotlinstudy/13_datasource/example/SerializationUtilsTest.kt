package com.survivaalcoding.kotlinstudy.`13_datasource`.example

import org.junit.Assert.assertEquals
import org.junit.Test

class SerializationUtilsTest {
    @Test
    fun `json 데이터를 역직렬화할 수 있다`() {
        // given
        val jsonData = """
            {
              "userId": 1,
              "id": 1,
              "title": "delectus aut autem",
              "completed": false
            }
            """.trimIndent()

        val id = 1
        val userId = 1
        val title = "delectus aut autem"
        val completed = false

        val todo = Todo(id, userId, title, completed)

        // when
        val actual: Todo = SerializationUtils.deserialization(jsonData)

        // then
        assertEquals(todo.id, actual.id)
        assertEquals(todo.userId, actual.userId)
        assertEquals(todo.title, actual.title)
        assertEquals(todo.completed, actual.completed)
    }

    @Test
    fun `csv 데이터를 json 데이터로 변경할 수 있다`() {
        // given
        val csvData = """
            symbol,name,exchange,assetType,ipoDate,delistingDate,status
            -P-HIZ,Presurance Holdings Inc,NASDAQ,Stock,2023-08-30,null,Active            
        """.trimIndent()

        val jsonData = """[{"symbol": "-P-HIZ","name": "Presurance Holdings Inc","exchange": "NASDAQ","assetType": "Stock","ipoDate": "2023-08-30","delistingDate": null,"status": "Active"}]""".trimIndent()

        // when
        val actual = SerializationUtils.csvToJson(csvData)

        // then
        assertEquals(jsonData, actual)
    }
}