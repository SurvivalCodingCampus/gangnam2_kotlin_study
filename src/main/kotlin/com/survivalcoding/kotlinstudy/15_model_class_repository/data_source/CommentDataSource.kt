package com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Comment

interface CommentDataSource {
    suspend fun getComments(): List<Comment>
}
