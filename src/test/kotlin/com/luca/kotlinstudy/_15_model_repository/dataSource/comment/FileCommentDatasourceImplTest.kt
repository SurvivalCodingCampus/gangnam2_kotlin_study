package com.luca.kotlinstudy._15_model_repository.dataSource.comment

import com.luca.kotlinstudy._15_model_repository.model.Comment
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File
import kotlin.io.path.createTempFile

class FileCommentDatasourceImplTest {

    @Test
    fun `JSON 파일을 읽어서 특정 postId의 댓글만 잘 반환한다`() = runBlocking {
        val expected = listOf(
            Comment(postId = 1, id = 1, name = "A", email = "a@test.com", body = "AAA"),
            Comment(postId = 1, id = 2, name = "B", email = "b@test.com", body = "BBB"),
            Comment(postId = 2, id = 3, name = "C", email = "c@test.com", body = "CCC")
        )

        val jsonText = Json.encodeToString(expected)

        // 임시 파일 생성 후 JSON 내용 쓰기
        val tempFile = createTempFile(suffix = ".json").toFile()
        tempFile.writeText(jsonText)

        // FileCommentDatasourceImpl 에 임시파일 경로 주입
        val dataSource = FileCommentDatasourceImpl(tempFile.path)

        val result = dataSource.getComments(postId = 1)
        assertEquals(2, result.size)
        assertTrue(result.all { it.postId == 1 })
        assertEquals(listOf(1, 2), result.map { it.id })
    }
}
