package com.sesac.practice.day15.repository

interface ImageRepository {
    suspend fun saveImage(url: String, path: String)
    suspend fun saveImages(urls: List<String>, directory: String)
    suspend fun saveImageIfNotExist(url: String, path: String): Boolean
}
