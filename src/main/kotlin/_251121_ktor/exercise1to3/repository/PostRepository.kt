package _251121_ktor.exercise1to3.repository

import _251121_ktor.exercise1to3.model.Post

interface PostRepository {
    suspend fun getPostsByKeyword(keyword: String): List<Post>
}