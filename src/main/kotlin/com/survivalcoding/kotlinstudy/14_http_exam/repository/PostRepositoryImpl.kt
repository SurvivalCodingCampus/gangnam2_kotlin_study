package com.survivalcoding.kotlinstudy.`14_http_exam`.repository

import Post
import com.survivalcoding.kotlinstudy.`14_http_exam`.data_source.RemoteDataSource

class PostRepositoryImpl(
    private val dataSource: RemoteDataSource
) : PostRepository {

    override suspend fun getPostsByKeyword(keyword: String): List<Post> {
        return dataSource.getPosts().filter { post ->
            post.title.lowercase()
                .contains(keyword.trim().lowercase())
        }
    }
}