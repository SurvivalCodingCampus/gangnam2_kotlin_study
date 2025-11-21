package com.sesac.practice.day15.repository

import com.sesac.practice.day15.datasource.RemoteDataSource
import com.sesac.practice.day15.model.Post

class PostRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
) : PostRepository {

    override suspend fun getPostsByKeyword(keyword: String): List<Post> {
        val body = remoteDataSource.getPosts().body ?: return listOf()

        return body.filter { it.title.contains(keyword) }
    }
}
