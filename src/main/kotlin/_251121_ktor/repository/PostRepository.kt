package _251121_ktor.repository

import _251121_ktor.model.Post

interface PostRepository {
    suspend fun getPostsByKeyword(keyword: String): List<Post>
}