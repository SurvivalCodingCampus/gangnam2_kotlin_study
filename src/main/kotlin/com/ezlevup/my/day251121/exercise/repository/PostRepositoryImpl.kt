package com.ezlevup.my.day251121.exercise.repository

import com.ezlevup.my.day251121.exercise.core.Response
import com.ezlevup.my.day251121.exercise.data_source.RemoteDataSource
import com.ezlevup.my.day251121.exercise.model.Post

class PostRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : PostRepository {
    override suspend fun getPosts(): Response<List<Post>> {
        return remoteDataSource.getPosts()
    }

    override suspend fun getPost(id: Int): Response<Post> {
        return remoteDataSource.getPost(id)
    }

    override suspend fun createPost(post: Post): Response<Post> {
        return remoteDataSource.createPost(post)
    }

    override suspend fun updatePost(
        id: Int,
        post: Post
    ): Response<Post> {
        return remoteDataSource.updatePost(id, post)
    }

    override suspend fun patchPost(
        id: Int,
        post: Post
    ): Response<Post> {
        return remoteDataSource.patchPost(id, post)
    }

    override suspend fun deletePost(id: Int): Boolean {
        return remoteDataSource.deletePost(id)
    }

    suspend fun getPostsByKeyword(keyword: String): List<Post> {
        return getPosts().body?.filter { it.title.contains(keyword) } ?: emptyList()
    }
}