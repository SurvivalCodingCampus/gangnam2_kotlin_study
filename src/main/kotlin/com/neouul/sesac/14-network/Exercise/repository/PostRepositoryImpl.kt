package com.neouul.sesac.`14-network`.Exercise.repository

import com.neouul.sesac.`14-network`.Exercise.data_source.RemoteDataSource
import com.neouul.sesac.`14-network`.Exercise.model.Post

class PostRepositoryImpl(
    private val dataSource: RemoteDataSource,
) : PostRepository {
    override suspend fun getPostsByKeyword(keyword: String): List<Post> {
        return dataSource.getPosts().body.filter { it.title.contains(keyword) }
    }
}