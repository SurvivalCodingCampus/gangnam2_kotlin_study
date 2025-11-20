package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.datasource.MockTodoDataSourceImpl
import com.survival.kotlinstudy.day15.model.Todo
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class TodoRepositoryImplTest {

    @Test
    fun `MockTodoRepository - getTodos() 테스트`(): Unit = runBlocking {
        val text = """
            [
              {
                "userId": 1,
                "id": 1,
                "title": "delectus aut autem",
                "completed": false
              },
              {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
              },
              {
                "userId": 1,
                "id": 3,
                "title": "fugiat veniam minus",
                "completed": false
              },
              {
                "userId": 1,
                "id": 4,
                "title": "et porro tempora",
                "completed": true
              },
              {
                "userId": 1,
                "id": 5,
                "title": "laboriosam mollitia et enim quasi adipisci quia provident illum",
                "completed": false
              }
            ]
        """.trimIndent()
        val repository = TodoRepositoryImpl(MockTodoDataSourceImpl(text))
        val expected = 5


        val list = repository.getTodos()


        assertEquals(expected, list.size)
        assertIs<List<Todo>>(list)

    }

    @Test
    fun `TodoRepositoryImpl 의 getCompletedTodos() 테스트`(): Unit = runBlocking {
        val text = """
            [
              {
                "userId": 1,
                "id": 1,
                "title": "delectus aut autem",
                "completed": true
              },
              {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": true
              },
              {
                "userId": 1,
                "id": 3,
                "title": "fugiat veniam minus",
                "completed": false
              },
              {
                "userId": 1,
                "id": 4,
                "title": "et porro tempora",
                "completed": true
              },
              {
                "userId": 1,
                "id": 5,
                "title": "laboriosam mollitia et enim quasi adipisci quia provident illum",
                "completed": false
              }
            ]
        """.trimIndent()
        val repository = TodoRepositoryImpl(MockTodoDataSourceImpl(text))
        val expected = 3

        val list = repository.getCompletedTodos()

        assertEquals(expected, list.size)
    }
}