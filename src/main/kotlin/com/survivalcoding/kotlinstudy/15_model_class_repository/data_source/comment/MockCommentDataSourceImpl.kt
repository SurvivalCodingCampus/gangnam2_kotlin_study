package com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source.comment

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Comment

class MockCommentDataSourceImpl : CommentDataSource {

    private val mockComments = listOf(
        Comment(
            postId = 1,
            id = 1,
            name = "id labore ex et quam laborum",
            email = "Eliseo@gardner.biz",
            body = "laudantium enim quasi est quidem magnam voluptate ipsam eos\n" +
                    "tempora quo necessitatibus\n" +
                    "dolor quam autem quasi\n" +
                    "reiciendis et nam sapiente accusantium"
        ),
        Comment(
            postId = 1,
            id = 2,
            name = "quo vero reiciendis velit similique earum",
            email = "Jayne_Kuhic@sydney.com",
            body = "est natus enim nihil est dolore omnis voluptatem numquam\n" +
                    "et omnis occaecati quod ullam at\n" +
                    "voluptatem error expedita pariatur\n" +
                    "nihil sint nostrum voluptatem reiciendis et"
        ),
        Comment(
            postId = 1,
            id = 3,
            name = "odio adipisci rerum aut animi",
            email = "Nikita@garfield.biz",
            body = "quia molestiae reprehenderit quasi aspernatur\n" +
                    "aut expedita occaecati aliquam eveniet laudantium\n" +
                    "omnis quibusdam delectus saepe quia accusamus maiores nam est\n" +
                    "cum et ducimus et vero voluptates excepturi deleniti ratione"
        ),
    )

    override suspend fun getComments(): List<Comment> = mockComments
}
