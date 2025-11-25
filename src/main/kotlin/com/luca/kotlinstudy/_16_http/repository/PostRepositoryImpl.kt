package com.luca.kotlinstudy._16_http.repository

import com.luca.kotlinstudy._16_http.datasource.RemoteDataSource
import com.luca.kotlinstudy._16_http.model.Post

class PostRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : PostRepository {

    override suspend fun getPostsByKeyword(keyword: String): List<Post> {
        val response = remoteDataSource.getPosts()

        if (response.statusCode != 200) return emptyList()

        return (response.body ?: emptyList()).filter { post ->
            post.title.contains(keyword, ignoreCase = true)
        }
    }
}
