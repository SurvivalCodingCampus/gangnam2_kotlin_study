package _251120_test_double_model_class_repository.exercise1

import _251120_test_double_model_class_repository.common_config.FILEPATH1
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class CommentDataSourceImplTest {

    @Test
    fun `comments_json을 읽어서 Comment객체로 변환한다`() = runTest {
        //given
        val commentDatasourceImpl = CommentDataSourceImpl(FILEPATH1)
        //when
        val comment = commentDatasourceImpl.getComments()
        //then

        //맨앞
        assertEquals(1, comment[0].postId)
        assertEquals(1, comment[0].id)
        assertEquals("id labore ex et quam laborum", comment[0].name)
        assertEquals("Eliseo@gardner.biz", comment[0].email)
        assertEquals(
            "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
            comment[0].body
        )

        //맨뒤
        assertEquals(100, comment.last().postId)
        assertEquals(500, comment.last().id)
        assertEquals("ex eaque eum natus", comment.last().name)
        assertEquals("Emma@joanny.ca", comment.last().email)
        assertEquals(
            "perspiciatis quis doloremque\nveniam nisi eos velit sed\nid totam inventore voluptatem laborum et eveniet\naut aut aut maxime quia temporibus ut omnis",
            comment.last().body
        )
    }

}