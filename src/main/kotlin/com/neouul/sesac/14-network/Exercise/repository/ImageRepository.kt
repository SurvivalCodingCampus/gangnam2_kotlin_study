package com.neouul.sesac.`14-network`.Exercise.repository

interface ImageRepository {
    suspend fun saveImage(url: String, path: String)
    suspend fun saveImages(urls: List<String>, directory: String)
    suspend fun saveImageIfNotExists(url: String, path: String): Boolean
}