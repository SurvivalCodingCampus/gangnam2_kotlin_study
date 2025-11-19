package _251119_datasource.exercise2

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class TodoDataSourceImplTest {
    @Test
    fun `todos_json을 읽어서 Todo 리스트 객체를 반환한다`() = runTest {
        //given
        val todoDataSourceImplTest = TodoDataSourceImpl()
        //when
        val todos = todoDataSourceImplTest.getTodos()
        //then
        assertEquals(1, todos[0].userId)
        assertEquals(1, todos[0].id)
        assertEquals("delectus aut autem", todos[0].title)
        assertEquals(false, todos[0].completed)
    }

}