package com.survivalcoding.kotlinstudy.`16_network`.repository

import com.survivalcoding.kotlinstudy.`16_network`.data_source.RemoteDataSource
import com.survivalcoding.kotlinstudy.`16_network`.model.Post

class PostRepositoryImpl(
    private val datasource: RemoteDataSource
) : PostRepository {
    override suspend fun getPostByKeyword(keyword: String): List<Post>? {
        return datasource.getPosts().body?.filter { it.title.contains(keyword, true) }  // 대소문자구분 없음
    }
}