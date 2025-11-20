package _251120_test_double_model_class_repository.exercise1

class MockCommentDatasourceImpl : CommentDataSource {
    private val mockComments = listOf(
        Comment("body1", "email1", 1, "name1", 1),
        Comment("body2", "email2", 2, "name2", 2),
        Comment("body3", "email3", 3, "name3", 3),
        Comment("body4", "email4", 4, "name4", 4)
    )

    override suspend fun getComments(): List<Comment> {
        return mockComments
    }
}