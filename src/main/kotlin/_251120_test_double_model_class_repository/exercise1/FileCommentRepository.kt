package _251120_test_double_model_class_repository.exercise1

interface FileCommentRepository {
    suspend fun getComments(postId: Int): List<Comment> //데이터 원형을 가공해서 뿌려준다.
}