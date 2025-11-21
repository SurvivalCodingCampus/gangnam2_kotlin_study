package _251120_test_double_model_class_repository.exercise1

interface CommentDataSource {
    suspend fun getComments(): List<Comment> // 원래 데이터를 그대로 가져온다.
}
