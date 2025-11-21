package com.hhp227.kotlinstudy.`14_repository`

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotNull

class CommentDataSourceTest {
    val mockCommentDataSource = MockCommentDataSourceImpl(filename = "comments.json")

    @Test
    fun `파일이 존재하는지 확인`() {
        val commentsJson = this::class.java.classLoader.getResource("comments.json")

        assertNotNull(commentsJson, "comments.json 파일이 존재해야 합니다.")
    }

    @Test
    fun `Comment리스트를 모두 불러오는지 테스트`() = runTest {
        val commentList = mockCommentDataSource.getAllComments()

        assertIs<List<Comment>>(commentList)
    }

    @Test
    fun `Comment리스트 크기가 일치한지 테스트`() = runTest {
        val commentList = mockCommentDataSource.getAllComments()
        val expected = 500

        assertEquals(expected, commentList.size)
    }

    @Test
    fun `Comment리스트 첫번째 객체가 일치한지 테스트`() = runTest {
        val expected = Comment(
            postId = 1,
            id = 1,
            name = "id labore ex et quam laborum",
            email = "Eliseo@gardner.biz",
            body = "laudantium enim quasi est quidem magnam voluptate ipsam eos\n" +
                    "tempora quo necessitatibus\n" +
                    "dolor quam autem quasi\n" +
                    "reiciendis et nam sapiente accusantium"
        )
        val commentList = mockCommentDataSource.getAllComments()
        val firstComment = commentList.first()

        assertEquals(expected, firstComment)
    }

    @Test
    fun `Comment리스트 마지막 객체가 일치한지 테스트`() = runTest {
        val expected = Comment(
            postId = 100,
            id = 500,
            name = "ex eaque eum natus",
            email = "Emma@joanny.ca",
            body = "perspiciatis quis doloremque\n" +
                    "veniam nisi eos velit sed\n" +
                    "id totam inventore voluptatem laborum et eveniet\n" +
                    "aut aut aut maxime quia temporibus ut omnis"
        )
        val commentList = mockCommentDataSource.getAllComments()
        val lastComment = commentList.last()

        assertEquals(expected, lastComment)
    }
}