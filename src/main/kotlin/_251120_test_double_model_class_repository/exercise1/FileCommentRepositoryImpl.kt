package _251120_test_double_model_class_repository.exercise1

import _251120_test_double_model_class_repository.common_config.FILEPATH1
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class FileCommentRepositoryImpl(
    private val commentDataSource: CommentDataSource
) : FileCommentRepository {
    override suspend fun getComments(postId: Int): List<Comment> {
        return commentDataSource.getComments().filter { it.postId == postId }
    }
}

fun main(): Unit = runBlocking {
    val commentRepositoryImpl = FileCommentRepositoryImpl(CommentDataSourceImpl(FILEPATH1))
    launch {
        println(commentRepositoryImpl.getComments(100).size)
    }
}