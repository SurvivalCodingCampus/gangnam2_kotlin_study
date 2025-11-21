package com.survival.kotlinstudy.day16.repository

import com.survival.kotlinstudy.day16.datasource.RemoteDataSource
import com.survival.kotlinstudy.day16.model.Post

class PostRepositoryImpl(
    private val dataSource: RemoteDataSource
) : PostRepository {
    override suspend fun getPostsByKeyword(keyword: String): List<Post>? {
        return dataSource.getPosts().body?.filter { it.title.contains(keyword) }
    }
}