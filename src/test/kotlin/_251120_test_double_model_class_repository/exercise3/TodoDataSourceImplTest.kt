package _251120_test_double_model_class_repository.exercise3

import _251120_test_double_model_class_repository.common_config.FILEPATH3
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test


class TodoDataSourceImplTest {
    @Test
    fun `todos_json을 읽어서 Todo객체로 변환한다`() = runTest {
        //given
        val todoDataSourceImpl = TodoDataSourceImpl(FILEPATH3)
        //when
        val todo = todoDataSourceImpl.getAllMemo()
        //then
        //맨앞
        assertEquals(1, todo.first().userId)
        assertEquals(1, todo.first().id)
        assertEquals("delectus aut autem", todo.first().title)
        assertEquals(false, todo.first().completed)
        //맨뒤
        assertEquals(10, todo.last().userId)
        assertEquals(200, todo.last().id)
        assertEquals("ipsam aperiam voluptates qui", todo.last().title)
        assertEquals(false, todo.last().completed)
    }
}