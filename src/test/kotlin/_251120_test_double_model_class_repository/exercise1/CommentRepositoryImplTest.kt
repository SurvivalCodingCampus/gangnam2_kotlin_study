package _251120_test_double_model_class_repository.exercise1

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class CommentRepositoryImplTest {
    val mockComment = MockCommentDatasourceImpl()
    val repository = CommentRepositoryImpl(mockComment)

    @Test
    fun `postId가 1인 모의 데이터의 수는 1개이다`() = runTest {
        assertEquals(1, repository.getComments(1).size)
    }

    @Test
    fun `postId가 9인 모의 데이터의 수는 없다`() = runTest {
        assertEquals(0, repository.getComments(9).size)
    }

}