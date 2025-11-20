package com.neouul.sesac.`13-modelClass-repository`.comments

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class CommentRepositoryImplTest {
    @Test
    fun `getComments가 특정 postId를 가진 데이터만 반환하는지 - MockCommentDatasourceImpl`() = runBlocking {
        // given
        // 1. 가짜 데이터 만들기
        val comments = listOf<Comment>(
            Comment(1, 11, "a", "a@email.com", "a"),
            Comment(2, 12, "b", "b@email.com", "b"),
            Comment(3, 13, "c", "c@email.com", "c"),
            Comment(1, 14, "d", "d@email.com", "d"),
            Comment(1, 15, "e", "e@email.com", "e"),
            Comment(4, 16, "f", "f@email.com", "f"),
        )
        // 2. MockCommentDatasourceImpl의 생성자로 가짜 데이터 전달하기
        val mockDataSource = MockCommentDatasourceImpl(comments)
        // 3. MockCommentDatasourceImpl의 인스턴스를 CommentRepositoryImpl의 생성자에 전달하기
        val commentRepository = CommentRepositoryImpl(mockDataSource)

        // when: postId == 1인 데이터만 받기
        val result = commentRepository.getComments(1)

        // then: 결과 리스트의 모든 인스턴스의 postId 값은 1이다
        result.forEach {
            assertEquals(1, it.postId)
        }

        // 3개의 인스턴스가 결과 리스트에 들어있는지
        assertEquals(1, result[0].postId)
        assertEquals(11, result[0].id)
        assertEquals("a", result[0].name)
        assertEquals("a@email.com", result[0].email)
        assertEquals("a", result[0].body)

        assertEquals(1, result[1].postId)
        assertEquals(14, result[1].id)
        assertEquals("d", result[1].name)
        assertEquals("d@email.com", result[1].email)
        assertEquals("d", result[1].body)

        assertEquals(1, result[2].postId)
        assertEquals(15, result[2].id)
        assertEquals("e", result[2].name)
        assertEquals("e@email.com", result[2].email)
        assertEquals("e", result[2].body)
    }

    @Test
    fun `getComments가 특정 postId를 가진 데이터만 반환하는지 - CommentDatasourceImpl`() = runBlocking {
        // given:
        // comments.json에서 데이터 들고오는 CommentDatasourceImpl 인스턴스를
        // CommentRepositoryImpl의 생성자에 전달하기
        val commentDatasource = CommentDataSourceImpl()     // 경로가 디폴트값으로 설정되어 있음
        val commentRepository = CommentRepositoryImpl(commentDatasource)

        // when: postId == 1인 데이터만 받기
        val result = commentRepository.getComments(1)

        // then: 결과 리스트의 모든 인스턴스의 postId 값은 1이다
        result.forEach {
            assertEquals(1, it.postId)
        }
    }
}