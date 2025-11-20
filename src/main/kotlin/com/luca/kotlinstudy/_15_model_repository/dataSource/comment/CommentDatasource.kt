package com.luca.kotlinstudy._15_model_repository.dataSource.comment

import com.luca.kotlinstudy._15_model_repository.model.Comment

// 댓글 데이터를 가져오는 역할만 정의한 DataSource 인터페이스
interface CommentDatasource {
    suspend fun getComments(postId: Int): List<Comment>
}