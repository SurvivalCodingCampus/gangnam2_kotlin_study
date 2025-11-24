package _251121_ktor.repository

import _251121_ktor.data_source.RemoteDataSource
import _251121_ktor.model.Post

class PostRepositoryImpl(
    val postDataSource: RemoteDataSource
) : PostRepository {
    override suspend fun getPostsByKeyword(keyword: String): List<Post> {
        return postDataSource.getPosts().body.filter { it.title?.contains(keyword) ?: false }
    }
}