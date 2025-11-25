package com.survivalcoding.kotlinstudy.`16_http`.practice.repository

import com.survivalcoding.kotlinstudy.`16_http`.practice.data_source.RemoteDataSource
import com.survivalcoding.kotlinstudy.`16_http`.practice.model.Post
import com.survivalcoding.kotlinstudy.repository.core.Response

class PostRepositoryImpl(
    private val dataSource: RemoteDataSource
) : PostRepository {
    override suspend fun getPostByKeyword(keyword: String): Response<List<Post>> {
        val allResponse = dataSource.getPost()
        val allPosts = allResponse.body

        return Response(
            statusCode = allResponse.statusCode,
            header = allResponse.header,
            body = allPosts.filter { it.title?.contains(keyword) == true }
        )
    }
}
