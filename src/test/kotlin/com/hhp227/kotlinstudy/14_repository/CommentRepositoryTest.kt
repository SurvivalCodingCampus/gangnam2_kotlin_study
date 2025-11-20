package com.hhp227.kotlinstudy.`14_repository`

import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CommentRepositoryTest {
    private val commentRepository = CommentRepositoryImpl(MockCommentDataSourceImpl(filename = "comments.json"))

    @Test
    fun `CommentRepository에서 5번 postId의 Comment들을 가져와서 크기가 맞는지 테스트`() = runTest {
        val postId = 5
        val commentList = commentRepository.getComments(postId)
        val expected = 5

        assertEquals(expected, commentList.size)
    }

    @Test
    fun `CommentRepository에서 4번 postId의 Comment들을 가져와서 일치하는지 테스트`() = runTest {
        val postId = 4
        val commentList = commentRepository.getComments(postId)

        val expected = listOf(
            Comment(
                postId = 4,
                id = 16,
                name = "perferendis temporibus delectus optio ea eum ratione dolorum",
                email = "Christine@ayana.info",
                body = """
                iste ut laborum aliquid velit facere itaque
                quo ut soluta dicta voluptate
                error tempore aut et
                sequi reiciendis dignissimos expedita consequuntur libero sed fugiat facilis
            """.trimIndent()
            ),
            Comment(
                postId = 4,
                id = 17,
                name = "eos est animi quis",
                email = "Preston_Hudson@blaise.tv",
                body = """
                consequatur necessitatibus totam sed sit dolorum
                recusandae quae odio excepturi voluptatum harum voluptas
                quisquam sit ad eveniet delectus
                doloribus odio qui non labore
            """.trimIndent()
            ),
            Comment(
                postId = 4,
                id = 18,
                name = "aut et tenetur ducimus illum aut nulla ab",
                email = "Vincenza_Klocko@albertha.name",
                body = """
                veritatis voluptates necessitatibus maiores corrupti
                neque et exercitationem amet sit et
                ullam velit sit magnam laborum
                magni ut molestias
            """.trimIndent()
            ),
            Comment(
                postId = 4,
                id = 19,
                name = "sed impedit rerum quia et et inventore unde officiis",
                email = "Madelynn.Gorczany@darion.biz",
                body = """
                doloribus est illo sed minima aperiam
                ut dignissimos accusantium tempore atque et aut molestiae
                magni ut accusamus voluptatem quos ut voluptates
                quisquam porro sed architecto ut
            """.trimIndent()
            ),
            Comment(
                postId = 4,
                id = 20,
                name = "molestias expedita iste aliquid voluptates",
                email = "Mariana_Orn@preston.org",
                body = """
                qui harum consequatur fugiat
                et eligendi perferendis at molestiae commodi ducimus
                doloremque asperiores numquam qui
                ut sit dignissimos reprehenderit tempore
            """.trimIndent()
            )
        )

        assertEquals(expected, commentList)
    }
}