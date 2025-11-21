package com.survivaalcoding.kotlinstudy.`15_network`.example.repository

import com.survivaalcoding.kotlinstudy.`15_network`.example.datasource.RemoteDataSource
import com.survivaalcoding.kotlinstudy.`15_network`.example.model.Post

class PostRepositoryImpl(val dataSource: RemoteDataSource) : PostRepository {
    override suspend fun getPosts(): List<Post> {
        val response = dataSource.getPosts()

        return response.body
    }

    override suspend fun getPost(id: Long): Post? {
        val response = dataSource.getPost(id)

        return response.body
    }

    override suspend fun createPost(post: Post): Post {
        val response = dataSource.createPost(post)

        return response.body
    }

    override suspend fun updatePost(
        id: Long,
        post: Post
    ): Post {
        val response = dataSource.updatePost(id, post)

        return response.body
    }

    override suspend fun patchPost(
        id: Long,
        post: Post
    ): Post {
        val response = dataSource.patchPost(id, post)

        return response.body
    }

    override suspend fun deletePost(id: Long) {
        val response = dataSource.deletePost(id)

        return response.body
    }

    override suspend fun getPostsByKeyword(keyword: String): List<Post> {
        val posts = getPosts()

        return posts.filter { post ->
            post.title.contains(keyword)
        }
    }
}