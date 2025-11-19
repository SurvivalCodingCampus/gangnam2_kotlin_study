package _251119_datasource.exercise1

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class TodoDataSourceImplTest {

    @Test
    fun `todo_json을 읽어서 Todo객체로 변환한다`() = runTest {
        //given
        val todoDataSourceImpl = TodoDataSourceImpl()
        //when
        val todo = todoDataSourceImpl.getTodo()
        //then
        assertEquals(1, todo.userId)
        assertEquals(1, todo.id)
        assertEquals("delectus aut autem", todo.title)
        assertEquals(false, todo.completed)
    }
}
