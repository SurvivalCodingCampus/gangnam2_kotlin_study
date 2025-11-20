package com.luca.kotlinstudy._15_model_repository

import com.luca.kotlinstudy._15_model_repository.Main.Companion.COMMENT_PATH
import com.luca.kotlinstudy._15_model_repository.Main.Companion.PHOTO_PATH
import com.luca.kotlinstudy._15_model_repository.dataSource.comment.FileCommentDatasourceImpl
import com.luca.kotlinstudy._15_model_repository.dataSource.comment.MockCommentDatasourceImpl
import com.luca.kotlinstudy._15_model_repository.dataSource.photo.FilePhotoDataSourceImpl
import com.luca.kotlinstudy._15_model_repository.dataSource.photo.MockPhotoDataSourceImpl
import com.luca.kotlinstudy._15_model_repository.repository.comment.CommentRepositoryImpl
import com.luca.kotlinstudy._15_model_repository.repository.photo.PhotoRepositoryImpl
import kotlinx.coroutines.runBlocking

/*
[main] -> [CommentRepository]-> [CommentRepositoryImpl] -> [CommentDataSource] -> [MockCommentDataSourceImpl]
-> [comments.json 읽기] -> [List<Comment>] 반환
 */
fun main() = runBlocking {
    val commentDataSource = FileCommentDatasourceImpl(COMMENT_PATH)
    val commentRepository = CommentRepositoryImpl(commentDataSource)
    val comments = commentRepository.getComments(1)
    println(comments)
    println("----------------------------------------")
    val mockDataSource = MockCommentDatasourceImpl()
    val mockCommonRepository = CommentRepositoryImpl(mockDataSource)
    val mockComments = mockCommonRepository.getComments(1)
    println(mockComments)
    println("----------------------------------------")

    val photoDataSource = FilePhotoDataSourceImpl(PHOTO_PATH)
    val photoRepository = PhotoRepositoryImpl(photoDataSource)
    val photos = photoRepository.getPhotos(1)
    println(photos)
    println("----------------------------------------")

    val mockPhotoDataSource = MockPhotoDataSourceImpl()
    val mockPhotoRepository = PhotoRepositoryImpl(mockPhotoDataSource)
    val mockPhotos = mockPhotoRepository.getPhotos(1)
    println(mockPhotos)
    println("----------------------------------------")
}

class Main() {
    companion object {
        const val COMMON_PATH = "src/main/kotlin/com/luca/kotlinstudy/_15_model_repository/dataSource/"
        const val COMMENT_PATH = COMMON_PATH + "comment/comments.json"
        const val PHOTO_PATH = COMMON_PATH + "photo/photos.json"
    }
}
