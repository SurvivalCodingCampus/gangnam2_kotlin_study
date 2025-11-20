package com.survival.kotlinstudy.day15.datasource

import com.survival.kotlinstudy.day15.model.Comment

interface CommentDatasource {
    suspend fun getComments(): List<Comment>
}