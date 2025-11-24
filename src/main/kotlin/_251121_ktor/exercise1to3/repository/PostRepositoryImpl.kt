package _251121_ktor.exercise1to3.repository

import _251121_ktor.exercise1to3.data_source.RemoteDataSource
import _251121_ktor.exercise1to3.model.Post

class PostRepositoryImpl(
    val postDataSource: RemoteDataSource
) : PostRepository {
    override suspend fun getPostsByKeyword(keyword: String): List<Post> {
        return postDataSource.getPosts().body.filter { it.title?.contains(keyword) ?: false }
    }
}