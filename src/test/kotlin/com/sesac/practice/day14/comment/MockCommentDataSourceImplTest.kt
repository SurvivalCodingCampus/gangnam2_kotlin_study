package com.sesac.practice.day14.comment

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class MockCommentDataSourceImplTest {
    @Test
    fun `comments_json 파일을 읽어서 Comment 리스트로 반환한다`() = runTest {
        // given
        val pathname = "data/comments.json"
        val dataSource = MockCommentDataSourceImpl(pathname)

        // when
        val comments = dataSource.getComments()

        // then
        assertEquals(500, comments.size)
    }
}
