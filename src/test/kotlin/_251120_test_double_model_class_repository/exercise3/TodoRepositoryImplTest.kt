package _251120_test_double_model_class_repository.exercise3

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals


class TodoRepositoryImplTest {
    val mockTodoDataSourceImpl = MockTodoDataSourceImpl()
    val repository = TodoRepositoryImpl(mockTodoDataSourceImpl)

    @Test
    fun `Mock객체의 메모가 4개 저장되어있다`() = runTest {
        assertEquals(4, repository.getTodos().size)
    }

    @Test
    fun `Mock객체에서 완료된 메모는 1개이다`() = runTest {
        assertEquals(1, repository.getCompletedTodos().size)
    }
}