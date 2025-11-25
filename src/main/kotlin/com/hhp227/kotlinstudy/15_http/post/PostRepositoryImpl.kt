package com.hhp227.kotlinstudy.`15_http`.post

class PostRepositoryImpl(
    private val postRemoteDataSource: PostRemoteDataSource
) : PostRepository {
    override suspend fun getPostsByKeyword(keyword: String): List<Post> {
        val response = postRemoteDataSource.getPosts()
        return if (response.statusCode == 200) {
            val data = response.data
            data.filter { it.title.contains(keyword) }
        } else {
            emptyList()
        }
    }
}